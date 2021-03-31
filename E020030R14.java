/*
 * ソフトバンク・ペイメント・サービス株式会社 All Copyright Reserved 2013-2014
 *
 * Created on 2014/01/29
 */
package jp.co.sbps.xten.app.webreport;

/**
 * <P>
 * E020030R14　本番環境接続情報（自社センタ）
 * </P>
 * <PRE><SMALL>
 * ===========================================================================
 * システム名　　　　: xTen
 * クラス名　　　　　: E020030R14
 * 作成者　　　　　　: ドウ
 * ---------------------------------------------------------------------------
 * メンテナンス履歴
 * ---------------------------------------------------------------------------
 * <VERSION> <改定内容>                <作成者>                 <リリース日>
 * ---------------------------------------------------------------------------
 *  001.000   新規作成                  ドウ                    2021/03/03
 * ===========================================================================
 * </SMALL></PRE>
 * @version $Revision: 1.0 $
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.sbps.xten.common.entity.TMerchantBasicinfo;
import jp.co.sbps.xten.common.entity.TMerchantInspectionstatusinfo;
import jp.co.sbps.xten.common.entity.TMerchantSettlemenattributeparameterinfo;
import jp.co.sbps.xten.common.entity.TMerchantSolutioninfo;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.engine.api.ReportEngine;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class E020030R14 {

	/**
	 * レポートエクスポート処理
	 *
	 * @param mId
	 * @param sId
	 * @return HashMap<String, String> ファイルパス、出力結果（0:OK,1:NG）
	 */
	public static HashMap<String, String> exportReport(String mId, String sId)
			throws RuntimeException {

		String companyname = "－";
		String storename = "－";
		String channelno = "－";
		String cardBrand = "－";
		String merchantNoName1 = "－";
		String merchantNo1 = "－";
		String merchantNoName2 = "－";
		String merchantNo2 = "－";
		String twoPay = "－";
		String partitionPay = "－";
		String revolvingPay = "－";
		String bonusPay = "－";
		String ginrenPayway = "－";

		String electronicMoney = "　";

		String limBackofficeUseraccount = "－";
		String limBackofficePassword = "－";
		String unlimBackofficeUseraccount = "－";
		String unlimBackofficePassword = "－";

		String tableUseraccount = "－";
		String tablePassword = "－";

		String terminalUseraccount = "－";
		String terminalPassword = "－";

		String codeSettleRefund = "－";

		List<String> electronicMoneyList = new ArrayList<>();

		List<String> cardBrandList = new ArrayList<>();

		String codeSettlement = "　";
		List<String> codeSettlementList = new ArrayList<>();

		JdbcManager jdbcManager = SingletonS2Container
				.getComponent("jdbcManager");

		HashMap<String, String> map = new HashMap<String, String>();

		try {

			// Linux環境用
			String pdfPath = "/mnt/xten/DATA/temp/";

			// PDF名はMID-SID_端末決済サービス　審査結果のご連絡.pdf
			String reportId = "端末決済サービス　審査結果のご連絡"; // 帳票ID
			String extension = ".pdf"; // 拡張子

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mid", mId);
			param.put("sid", sId);

			// お客様情報
			List<TMerchantBasicinfo> custmerinfo = jdbcManager.selectBySqlFile(
					TMerchantBasicinfo.class, "jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0001.sql",
					param).getResultList();

			if (custmerinfo != null && custmerinfo.size() != 0) {

				companyname = custmerinfo.get(0).companyname;
				storename = custmerinfo.get(0).storename;
				if (custmerinfo.get(0).channelno != null
						&& custmerinfo.get(0).channelno.length() > 0) {
					channelno = custmerinfo.get(0).channelno;
				}

				// 端末初期認証情報（無条件で編集
				terminalUseraccount = custmerinfo.get(0).backofficeUseraccount;
				terminalPassword = custmerinfo.get(0).backofficePassword;

			}

			// 加盟店決済属性パラメータ情報
			param.put("settlementcompanyid", "10624");
			List<TMerchantSettlemenattributeparameterinfo> parameterInfo1 = jdbcManager.selectBySqlFile(
					TMerchantSettlemenattributeparameterinfo.class, "jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0002.sql",
					param).getResultList();

			param.put("settlementcompanyid", "10607");
			List<TMerchantSettlemenattributeparameterinfo> parameterInfo2 = jdbcManager.selectBySqlFile(
					TMerchantSettlemenattributeparameterinfo.class, "jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0002.sql",
					param).getResultList();

			String settlementcompanyid_10624 = null;
			String settlementcompanyid_10607 = null;
			String setupval2Y1 = null;
			String setupval2Y2 = null;
			String setupval2Y3 = null;
			String setupval2Y4 = null;
			String setupval2YC = null;
			String setupval2YD = null;
			String setupval2YE = null;
			String setupval2YF = null;

			if (parameterInfo1 != null && parameterInfo1.size() != 0) {

				// 決済機関ID
				settlementcompanyid_10624 = "10624";

				for (int i = 0; i < parameterInfo1.size(); i++) {

					// 設定値の取得
					switch (parameterInfo1.get(i).parameterid) {
			    	case "2Y1":
			    		setupval2Y1 = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2Y2":
			    		setupval2Y2 = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2Y3":
			    		setupval2Y3 = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2Y4":
			    		setupval2Y4 = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2YC":
			    		setupval2YC = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2YD":
			    		setupval2YD = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2YE":
			    		setupval2YE = parameterInfo1.get(i).setupval;
			    		break;
			    	case "2YF":
			    		setupval2YF = parameterInfo1.get(i).setupval;
			    		break;
			    	}


				}

				// 契約情報の設定
				if ("1".equals(setupval2Y1)) {

					merchantNoName1 = "加盟店番号(V/M）";
					if (StringUtils.isNotEmpty(setupval2Y3)) {
						merchantNo1 = setupval2Y3;
					} else {
						merchantNo1 = "　";
					}
					if ("1".equals(setupval2Y2)) {
						merchantNoName2 = "加盟店番号（銀聯）";
						if (StringUtils.isNotEmpty(setupval2Y4)) {
							merchantNo2 = setupval2Y4;
						} else {
							merchantNo2 = "　";
						}
					}


				} else if ("0".equals(setupval2Y1) && "1".equals(setupval2Y2)) {

					merchantNoName1 = "加盟店番号（銀聯）";
					if (StringUtils.isNotEmpty(setupval2Y4)) {
						merchantNo1 = setupval2Y4;
					} else {
						merchantNo1 = "　";
					}
					merchantNoName2 = "　";
					merchantNo2 = "　";

				} else {

					merchantNoName1 = "　";
					merchantNo1 = "　";
					merchantNoName2 = "　";
					merchantNo2 = "　";

				}

				// 支払情報の設定
				if ("1".equals(setupval2YC)) {
					twoPay = "●";
				} else {
					twoPay = "　";
				}

				if ("1".equals(setupval2YD)) {
					partitionPay = "●";
				} else {
					partitionPay = "　";
				}

				if ("1".equals(setupval2YE)) {
					revolvingPay = "●";
				} else {
					revolvingPay = "　";
				}

				if ("1".equals(setupval2YF)) {
					bonusPay = "●";
				} else {
					bonusPay = "　";
				}

				if ("1".equals(setupval2Y2)) {
					ginrenPayway = "※　　銀聯の支払方法につきましては、1回払いのみとなります";
				} else {
					ginrenPayway = "　";
				}
			}

			if (parameterInfo2 != null && parameterInfo2.size() != 0) {
				settlementcompanyid_10607 = "10607";
			}


			// 電子マネー決済対象取得SQL
			List<TMerchantInspectionstatusinfo> paymentInfo = jdbcManager.selectBySqlFile(
					TMerchantInspectionstatusinfo.class, "jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0003.sql",param).getResultList();

			if (paymentInfo != null && paymentInfo.size() != 0) {

				String inspectionresult_10607 = null;

				String inspectionresult_10701 = null;

				String inspectionresult_10801 = null;

				String inspectionresult_10902 = null;

				String inspectionresult_11002 = null;

				String inspectionresult_11102 = null;

				String inspectionresult_11201 = null;

				String inspectionresult_93101 = null;

				String inspectionresult_93201 = null;

				String inspectionresult_93501 = null;

				String inspectionresult_93601 = null;

				String inspectionresult_93701 = null;

				String inspectionresult_93801 = null;

				String inspectionresult_93901 = null;

				String inspectionresult_94001 = null;

				String inspectionresult_94101 = null;

				String inspectionresult_94301 = null;

				String inspectionresult_94401 = null;

				String inspectionresult_94501 = null;

				String inspectionresult_94601 = null;

				String inspectionresult_94701 = null;

				for(int i = 0; i < paymentInfo.size(); i++){

					//審査結果の取得
					switch (paymentInfo.get(i).settlementcompanyid){

					case "10607":
						inspectionresult_10607 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "10701":
						inspectionresult_10701 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "10801":
						inspectionresult_10801 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "10902":
						inspectionresult_10902 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "11002":
						inspectionresult_11002 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "11102":
						inspectionresult_11102 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "11201":
						inspectionresult_11201 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93101":
						inspectionresult_93101 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93201":
						inspectionresult_93201 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93501":
						inspectionresult_93501 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93601":
						inspectionresult_93601 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93701":
						inspectionresult_93701 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93801":
						inspectionresult_93801 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "93901":
						inspectionresult_93901 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94001":
						inspectionresult_94001 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94101":
						inspectionresult_94101 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94301":
						inspectionresult_94301 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94401":
						inspectionresult_94401 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94501":
						inspectionresult_94501 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94601":
						inspectionresult_94601 = paymentInfo.get(i).inspectionresult;
			    		break;
					case "94701":
						inspectionresult_94701 = paymentInfo.get(i).inspectionresult;
			    		break;
					}
				}

				// カードブランドの設定
				if ("10624".equals(settlementcompanyid_10624) && "1".equals(setupval2Y1)) {
					cardBrandList.add("VISA / MasterCard");
				}
				if ("10624".equals(settlementcompanyid_10624) && "1".equals(setupval2Y2)) {
					cardBrandList.add("銀聯");
				}
				if ("10607".equals(settlementcompanyid_10607) && "06".equals(inspectionresult_10607)) {
					cardBrandList.add("JCB / AMEX / DINERS / DISCOVER");
				}
				if(cardBrandList.isEmpty()){
					cardBrandList.add("　");
				}

				cardBrand = cardBrandList.toString().replace("[", "").replace("]","");

				//電子マネー決済の確認
				if("06".equals(inspectionresult_10701)){
					electronicMoneyList.add("交通系ＩＣ");
				}

				if("06".equals(inspectionresult_10801)){
					electronicMoneyList.add("楽天Ｅｄｙ");
				}

				if("06".equals(inspectionresult_10902)){
					electronicMoneyList.add("iD");
				}

				if("06".equals(inspectionresult_11002)){
					electronicMoneyList.add("WAON");
				}

				if("06".equals(inspectionresult_11102)){
					electronicMoneyList.add("nanaco");
				}

				if("06".equals(inspectionresult_11201)){
					electronicMoneyList.add("QUICPay");
				}

				if(electronicMoneyList.isEmpty()){
					electronicMoneyList.add("　");
				}

				electronicMoney = electronicMoneyList.toString().replace("[", "").replace("]","");

				//コード決済の確認
				if("06".equals(inspectionresult_93101)){
					codeSettlementList.add("WeChat Pay");
				}

				if("06".equals(inspectionresult_93201)){
					codeSettlementList.add("Alipay");
				}

				if("06".equals(inspectionresult_93501)){
					codeSettlementList.add("銀聯");
				}

				if("06".equals(inspectionresult_93601)){
					codeSettlementList.add("PayPay");
				}

				if("06".equals(inspectionresult_93701)){
					codeSettlementList.add("楽天ペイ");
				}

				if("06".equals(inspectionresult_93801)){
					codeSettlementList.add("d払い");
				}

				if("06".equals(inspectionresult_93901)){
					codeSettlementList.add("LINE Pay");
				}

				if("06".equals(inspectionresult_94001)){
					codeSettlementList.add("au PAY");
				}

				if("06".equals(inspectionresult_94101)){
					codeSettlementList.add("メルペイ");
				}

				if("06".equals(inspectionresult_94301)){
					codeSettlementList.add("JKOPAY");
				}

				if("06".equals(inspectionresult_94401)){
					codeSettlementList.add("J-Coin Pay");
				}

				if("06".equals(inspectionresult_94501)){
					codeSettlementList.add("SmartCode");
				}

				if("06".equals(inspectionresult_94601)){
					codeSettlementList.add("QUOカードPay");
				}

				if("06".equals(inspectionresult_94701)){
					codeSettlementList.add("Alipay+");
				}

				if(codeSettlementList.isEmpty()){
					codeSettlementList.add("　");
				}

				codeSettlement = codeSettlementList.toString().replace("[", "").replace("]","");
			}

			// コード決済返金情報
			List<TMerchantSolutioninfo> codeSettleRefundList = jdbcManager
					.selectBySqlFile(TMerchantSolutioninfo.class,
							"jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0008.sql", param)
					.getResultList();
			if (codeSettleRefundList != null
					&& codeSettleRefundList.size() != 0
					&& codeSettlementList.size() > 0
					&& !codeSettlementList.contains("　")) {
				codeSettleRefund = codeSettleRefundList.get(0).setupval;
			}

			// 管理画面（制限なし）
			List<TMerchantBasicinfo> unlimManegeinfo = jdbcManager
					.selectBySqlFile(TMerchantBasicinfo.class,
							"jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0004.sql", param)
					.getResultList();

			if (unlimManegeinfo != null && unlimManegeinfo.size() != 0) {

				unlimBackofficeUseraccount = unlimManegeinfo.get(0).backofficeUseraccount;
				unlimBackofficePassword = unlimManegeinfo.get(0).backofficePassword;

			}

			// 管理画面（制限あり）
			List<TMerchantBasicinfo> limManegeinfo = jdbcManager
					.selectBySqlFile(TMerchantBasicinfo.class,
							"jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0005.sql", param)
					.getResultList();

			if (limManegeinfo != null && limManegeinfo.size() != 0) {

				limBackofficeUseraccount = limManegeinfo.get(0).backofficeUseraccount;
				limBackofficePassword = limManegeinfo.get(0).backofficePassword;

			}

			// 管理画面代表アカウント情報 代表設定アカウントID
			List<TMerchantSolutioninfo> ManegeAccountinfo = jdbcManager
					.selectBySqlFile(TMerchantSolutioninfo.class,
							"jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0006.sql", param)
					.getResultList();

			if (ManegeAccountinfo != null
					&& ManegeAccountinfo.size() != 0) {

				if (ManegeAccountinfo.get(0).setupval != null
						&& ManegeAccountinfo.get(0).setupval.length() > 0) {
					tableUseraccount = ManegeAccountinfo.get(0).setupval;
				}

			}

			//管理画面代表アカウント情報 代表設定パスワード
			List<TMerchantSolutioninfo> ManegePassinfo = jdbcManager
					.selectBySqlFile(TMerchantSolutioninfo.class,
							"jp/co/sbps/xten/app/service/reportsql/E020030R14_SEL_0007.sql", param)
					.getResultList();

			if (ManegePassinfo != null && ManegePassinfo.size() != 0) {

				if (ManegePassinfo.get(0).setupval != null
						&& ManegePassinfo.get(0).setupval.length() > 0) {
					tablePassword = ManegePassinfo.get(0).setupval;
				}

			}

			EngineConfig config = new EngineConfig();
			// レポートエンジン生成とレポートファイル読み込み
			ReportEngine engine = new ReportEngine(config);
			IReportRunnable design = engine
					.openReportDesign("/share/xten/batch/report/E020030R14.rptdesign");

			// タスク生成
			IRunAndRenderTask task = engine.createRunAndRenderTask(design);

			// PDF設定
			RenderOption options = new PDFRenderOption();
			String pdfFullPath = pdfPath + mId + "-" + sId + "_" + reportId
					+ extension;
			map.put("pdfFullPath", pdfFullPath);
			System.out.println("pdfFullPath:" + pdfFullPath);

			task.setParameterValue("Mid", mId);
			task.setParameterValue("Sid", sId);
			task.setParameterValue("companyname", companyname);
			task.setParameterValue("storename", storename);
			task.setParameterValue("channelno", channelno);
			task.setParameterValue("cardBrand", cardBrand);
			task.setParameterValue("electronicMoney", electronicMoney);
			task.setParameterValue("codeSettlement", codeSettlement);
			task.setParameterValue("merchantNoName1", merchantNoName1);
			task.setParameterValue("merchantNo1", merchantNo1);
			task.setParameterValue("merchantNoName2", merchantNoName2);
			task.setParameterValue("merchantNo2", merchantNo2);
			task.setParameterValue("twoPay", twoPay);
			task.setParameterValue("partitionPay", partitionPay);
			task.setParameterValue("revolvingPay", revolvingPay);
			task.setParameterValue("bonusPay", bonusPay);
			task.setParameterValue("ginrenPayway", ginrenPayway);

			task.setParameterValue("limBackofficeUseraccount",
					limBackofficeUseraccount);
			task.setParameterValue("limBackofficePassword",
					limBackofficePassword);
			task.setParameterValue("unlimBackofficeUseraccount",
					unlimBackofficeUseraccount);
			task.setParameterValue("unlimBackofficePassword",
					unlimBackofficePassword);

			task.setParameterValue("tableUseraccount", tableUseraccount);
			task.setParameterValue("tablePassword", tablePassword);
			task.setParameterValue("terminalUseraccount", terminalUseraccount);
			task.setParameterValue("terminalPassword", terminalPassword);
			task.setParameterValue("codeSettleRefund", codeSettleRefund);

			options.setOutputFileName(pdfFullPath);
			options.setOutputFormat(RenderOption.OUTPUT_FORMAT_PDF);
			task.setRenderOption(options);

			// 実行
			task.run();

			engine.destroy();

		} catch (Exception e) {
			e.printStackTrace();

			map.put("judge", "1");

			return map;

		}

		map.put("judge", "0");

		return map;
	}

	public static void main(String[] args) {

		SingletonS2ContainerFactory.init();
		exportReport("72534", "009");

	}
}
