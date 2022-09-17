package actions;

import locators.QAEngineerPageLocator;
import utils.CommonUtils;

public class QAEngineerPageAction {
    public static QAEngineerPageLocator locator = new QAEngineerPageLocator();

    public static String getHeader() {
        return locator.header.getText();
    }

    public static void scrollToApplyBtn() {
        CommonUtils.scrollToElement(locator.applyHereNowBtn, 100);
    }
    public static boolean isVisibleEnabledApplyBtn() {
        return locator.applyHereNowBtn.isDisplayed() && locator.applyHereNowBtn.isEnabled();
    }
    public static void clickApplyHereNowBtn() {
        locator.applyHereNowBtn.click();
    }
}
