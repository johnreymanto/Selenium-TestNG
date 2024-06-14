package Utility;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Objects;
import Utility.LocatorManager.*;

public class ByLocator extends BaseDriver{

    /**
     * Loader elements
     */
    public static final By spinLoader = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("spinLoader")));
    public static final By backDrop = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("backDrop")));


    /**
     * Buttons
     * Array of locators for 1 element sample syntax
    static LocatorManager.LocatorInfo createbtnArray = Objects.requireNonNull(LocatorManager.getLocatorInfo("createBtnArray"));
    public static final By createBtnArray = getByLocator(createbtnArray);
     *
     */

    public static final By createBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("createBtn")));
    public static final By xBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("xBtn")));
    public static final By okBtn = getByLocator(LocatorManager.getLocatorInfo("okBtn"));
    public static final By modalOkBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("modalOkBtn")));
    public static final By modalCancelBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("modalCancelBtn")));
    public static final By saveBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("saveBtn")));
    public static final By cancelBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("cancelBtn")));
    public static final By funnelBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("funnelBtn")));
    public static final By colExpStatusBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("colExpStatusBtn")));
    public static final By filterApplyBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("filterApplyBtn")));
    public static final By statusFilterClearBtn = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("statusFilterClearBtn")));
    static LocatorManager.LocatorInfo activityLogBtns = Objects.requireNonNull(LocatorManager.getLocatorInfo("activityLogBtn"));
    public static final By activityLogBtn = getByLocator(activityLogBtns);
    public static final By searchBtn = getByLocator(LocatorManager.getLocatorInfo("searchBtn"));
    public static final By exportBtn = getByLocator(LocatorManager.getLocatorInfo("exportBtn"));
    public static final By activityLogClearBtn = getByLocator(LocatorManager.getLocatorInfo("activityLogClearBtn"));
    public static final By addressBookBtn = getByLocator(LocatorManager.getLocatorInfo("addressBookBtn"));
    public static final By addressBookPlusButton = getByLocator(LocatorManager.getLocatorInfo("addressBookPlusButton"));
    public static final By addressBookAddButton = getByLocator(LocatorManager.getLocatorInfo("addressBookAddButton"));


    /**
     * Fields
     */

    public static final By chargeTypeId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeTypeId")));
    public static final By registrationCTId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("registrationCTId")));
    public static final By adminCTId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("adminCTId")));
    public static final By duplicateInvoiceId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("duplicateInvoiceId")));
    public static final By generalId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("generalId")));
    public static final By profitCentreId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("profitCentreId")));
    public static final By chargeItemName = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeItemName")));
    public static final By chargeItemDesc = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeItemDesc")));
    public static final By baseCurrencyId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("baseCurrencyId")));
    public static final By sgdBCId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("sgdBCId")));
    public static final By usdBCId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("usdBCId")));
    public static final By gstApplicableTrue = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("gstApplicableTrue")));
    public static final By gstApplicableFalse = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("gstApplicableFalse")));
    public static final By chargeAmount = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeAmount")));
    public static final By glNumberId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("glNumberId")));
    public static final By glNumberIdValue1 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("glNumberIdValue1")));
    public static final By glNumberIdValue2 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("glNumberIdValue2")));
    public static final By glNumberIdValue3 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("glNumberIdValue3")));
    public static final By glNumberIdValue4 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("glNumberIdValue4")));
    public static final By refundableId = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("refundableId")));
    public static final By tagToRegistrationTrue = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("tagToRegistrationTrue")));
    public static final By searchCI = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchCI")));
    public static final By tagToRegistrationFalse = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("tagToRegistrationFalse")));
    public static final By profitCentreIdValue1 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("profitCentreIdValue1")));
    public static final By profitCentreIdValue2 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("profitCentreIdValue2")));
    public static final By errorMessage1 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("errorMessage1")));
    public static final By mandatoryErrorMessage1 = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("mandatoryErrorMessage1")));
    public static final By modalBody = getByLocator(LocatorManager.getLocatorInfo("modalBody"));
    public static final By modalConfirmContent = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("modalConfirmContent")));
    public static final By maxTextArea = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("maxTextArea")));
    public static final By createDrawerTitle = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("createDrawerTitle")));
    public static final By chargeTotalItem = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeTotalItem")));
    public static final By statusFilterActive = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("statusFilterActive")));
    public static final By statusFilterInactive = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("statusFilterInactive")));
    public static final By selectedTag = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("selectedTag")));
    public static final By noItemError = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("noItemError")));
    public static final By min3CharError = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("min3CharError")));
    public static final By showRowsDropdown = getByLocator(LocatorManager.getLocatorInfo("showRowsDropdown"));
    public static final By activityLogShowRowsDropdown = getByLocator(LocatorManager.getLocatorInfo("activityLogShowRowsDropdown"));
    public static final By showRows10 = getByLocator(LocatorManager.getLocatorInfo("showRows10"));
    public static final By showRows20 = getByLocator(LocatorManager.getLocatorInfo("showRows20"));
    public static final By showRows50 = getByLocator(LocatorManager.getLocatorInfo("showRows50"));
    public static final By showRows100 = getByLocator(LocatorManager.getLocatorInfo("showRows100"));
    public static final By searchType = getByLocator(LocatorManager.getLocatorInfo("searchType"));
    public static final By activityLogTransactionCode = getByLocator(LocatorManager.getLocatorInfo("activityLogTransactionCode"));
    public static final By activityLogTransactionId = getByLocator(LocatorManager.getLocatorInfo("activityLogTransactionId"));
    public static final By activityLogChangeId = getByLocator(LocatorManager.getLocatorInfo("activityLogChangeId"));
    public static final By activityLogSectionImpacted = getByLocator(LocatorManager.getLocatorInfo("activityLogSectionImpacted"));
    public static final By activityLogFieldImpacted = getByLocator(LocatorManager.getLocatorInfo("activityLogFieldImpacted"));
    public static final By activityLogOldValue = getByLocator(LocatorManager.getLocatorInfo("activityLogOldValue"));
    public static final By activityLogNewValue = getByLocator(LocatorManager.getLocatorInfo("activityLogNewValue"));
    public static final By activityLogReason = getByLocator(LocatorManager.getLocatorInfo("activityLogReason"));
    public static final By activityLogDepartment = getByLocator(LocatorManager.getLocatorInfo("activityLogDepartment"));
    public static final By searchText = getByLocator(LocatorManager.getLocatorInfo("searchText"));
    public static final By searchDateRange = getByLocator(LocatorManager.getLocatorInfo("searchDateRange"));
    public static final By dateRangeStartPick = getByLocator(LocatorManager.getLocatorInfo("dateRangeStartPick"));
    public static final By dateRangeEndPick = getByLocator(LocatorManager.getLocatorInfo("dateRangeEndPick"));
    public static final By dateRangeTodayPick = getByLocator(LocatorManager.getLocatorInfo("dateRangeTodayPick"));
    public static final By searchTypeValue = getByLocator(LocatorManager.getLocatorInfo("searchTypeValue"));
    public static final By searchModifiedBy = getByLocator(LocatorManager.getLocatorInfo("searchModifiedBy"));
    public static final By searchModifiedByValue1 = getByLocator(LocatorManager.getLocatorInfo("searchModifiedByValue1"));
    public static final By searchModifiedByValue2 = getByLocator(LocatorManager.getLocatorInfo("searchModifiedByValue2"));
    public static final By activityLogModifiedByDName = getByLocator(LocatorManager.getLocatorInfo("activityLogModifiedByDName"));
    public static final By activityLogModifiedByDName1 = getByLocator(LocatorManager.getLocatorInfo("activityLogModifiedByDName1"));
    public static final By modifiedByError = getByLocator(LocatorManager.getLocatorInfo("modifiedByError"));
    public static final By activityLogAction = getByLocator(LocatorManager.getLocatorInfo("activityLogAction"));
    public static final By activityLogActionCreate = getByLocator(LocatorManager.getLocatorInfo("activityLogActionCreate"));
    public static final By activityLogActionEdit = getByLocator(LocatorManager.getLocatorInfo("activityLogActionEdit"));
    public static final By activityLogActionActivate = getByLocator(LocatorManager.getLocatorInfo("activityLogActionActivate"));
    public static final By activityLogActionDeactivate = getByLocator(LocatorManager.getLocatorInfo("activityLogActionDeactivate"));
    public static final By activityLogActionCreateSelected = getByLocator(LocatorManager.getLocatorInfo("activityLogActionCreateSelected"));
    public static final By activityLogActionEditSelected = getByLocator(LocatorManager.getLocatorInfo("activityLogActionEditSelected"));
    public static final By activityLogActionActivateSelected = getByLocator(LocatorManager.getLocatorInfo("activityLogActionActivateSelected"));
    public static final By activityLogActionDeactivateSelected = getByLocator(LocatorManager.getLocatorInfo("activityLogActionDeactivateSelected"));
    public static final By notificationMessage1 = getByLocator(LocatorManager.getLocatorInfo("notificationMessage1"));
    public static final By activityLogSearchTypeDefaultValue = getByLocator(LocatorManager.getLocatorInfo("activityLogSearchTypeDefaultValue"));
    public static final By activityLogModifiedByDefaultValue = getByLocator(LocatorManager.getLocatorInfo("activityLogModifiedByDefaultValue"));
    public static final By activityLogActionDefaultValue = getByLocator(LocatorManager.getLocatorInfo("activityLogActionDefaultValue"));
    public static final By activityLogDateRangeDefaultValue = getByLocator(LocatorManager.getLocatorInfo("activityLogDateRangeDefaultValue"));
    public static final By addressBookTitle = getByLocator(LocatorManager.getLocatorInfo("addressBookTitle"));
    public static final By addressBookTotalAccount = getByLocator(LocatorManager.getLocatorInfo("addressBookTotalAccount"));
    public static final By addressBookShowRowValue = getByLocator(LocatorManager.getLocatorInfo("addressBookShowRowValue"));
    public static final By addressBookPageOfValue = getByLocator(LocatorManager.getLocatorInfo("addressBookPageOfValue"));



    /**
     * WebPages
     */
    public static final By billPage = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("billPage")));
    public static final By billConfigPage = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("billConfigPage")));
    public static final By chargeItemPage = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeItemPage")));

    /**
     * Table
     */

    public static final By itemRow = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("itemRow")));
    public static final By modalALItemRow = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("modalALItemRow")));
    public static final By searchCItem = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchCItem")));
    public static final By searchCItemTypeList = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchCItemTypeList")));
    public static final By searchCItemNameList = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchCItemNameList")));
    public static final By searchCItemStatusList = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchCItemStatusList")));
    public static final By searchALTranCodeList = getByLocator(LocatorManager.getLocatorInfo("searchALTranCodeList"));
    public static final By searchALTranIdList = getByLocator(LocatorManager.getLocatorInfo("searchALTranIdList"));
    public static final By searchALChangeIdList = getByLocator(LocatorManager.getLocatorInfo("searchALChangeIdList"));
    public static final By searchALActionList = getByLocator(LocatorManager.getLocatorInfo("searchALActionList"));
    public static final By searchALSectionImpactedList = getByLocator(LocatorManager.getLocatorInfo("searchALSectionImpactedList"));
    public static final By searchALFieldImpactedList = getByLocator(LocatorManager.getLocatorInfo("searchALFieldImpactedList"));
    public static final By searchALOldValueList = getByLocator(LocatorManager.getLocatorInfo("searchALOldValueList"));
    public static final By searchALNewValueList = getByLocator(LocatorManager.getLocatorInfo("searchALNewValueList"));
    public static final By searchALReasonList = getByLocator(LocatorManager.getLocatorInfo("searchALReasonList"));
    public static final By searchALModifiedByList = getByLocator(LocatorManager.getLocatorInfo("searchALModifiedByList"));
    public static final By searchALDepartmentList = getByLocator(LocatorManager.getLocatorInfo("searchALDepartmentList"));
    public static final By searchALModifiedOnList = getByLocator(LocatorManager.getLocatorInfo("searchALModifiedOnList"));
    public static final By firstColItemList = getByLocator(LocatorManager.getLocatorInfo("firstColItemList"));
    public static final By secondColItemList = getByLocator(LocatorManager.getLocatorInfo("secondColItemList"));
    public static final By thirdColItemList = getByLocator(LocatorManager.getLocatorInfo("thirdColItemList"));
    public static final By fourthColItemList = getByLocator(LocatorManager.getLocatorInfo("fourthColItemList"));
    public static final By fifthColItemList = getByLocator(LocatorManager.getLocatorInfo("fifthColItemList"));
    public static final By sixthColItemList = getByLocator(LocatorManager.getLocatorInfo("sixthColItemList"));
    public static final By seventhColItemList = getByLocator(LocatorManager.getLocatorInfo("seventhColItemList"));
    public static final By eighthColItemList = getByLocator(LocatorManager.getLocatorInfo("eighthColItemList"));
    public static final By ninthColItemList = getByLocator(LocatorManager.getLocatorInfo("ninthColItemList"));
    public static final By twelfthColItemList = getByLocator(LocatorManager.getLocatorInfo("twelfthColItemList"));
    public static final By thirteenthColItemList = getByLocator(LocatorManager.getLocatorInfo("thirteenthColItemList"));
    public static final By fourteenthColItemList = getByLocator(LocatorManager.getLocatorInfo("fourteenthColItemList"));
    public static final By chargeItemColStatusValue = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("chargeItemColStatusValue")));
    public static final By activityLogTable = getByLocator(LocatorManager.getLocatorInfo("activityLogTable"));
    public static final By activityLogDeptColTitle = getByLocator(LocatorManager.getLocatorInfo("activityLogDeptColTitle"));
    public static final By activityLogModifiedByTitle = getByLocator(LocatorManager.getLocatorInfo("activityLogModifiedByTitle"));
    public static final By activityLogModifiedOnTitle = getByLocator(LocatorManager.getLocatorInfo("activityLogModifiedOnTitle"));
    public static final By activityLogDateRangePreview = getByLocator(LocatorManager.getLocatorInfo("activityLogDateRangePreview"));
    public static final By searchALPerModifiedByList = getByLocator(LocatorManager.getLocatorInfo("searchALPerModifiedByList"));
    public static final By activityLogDepartmentColFiltered = getByLocator(LocatorManager.getLocatorInfo("activityLogDepartmentColFiltered"));
    public static final By addressBookNameCol = getByLocator(LocatorManager.getLocatorInfo("addressBookNameCol"));
    public static final By addressBookNameList = getByLocator(LocatorManager.getLocatorInfo("addressBookNameList"));
    public static final By addressBookDepartmentList = getByLocator(LocatorManager.getLocatorInfo("addressBookDepartmentList"));
    public static final By addressBookPlusBtnList = getByLocator(LocatorManager.getLocatorInfo("addressBookPlusBtnList"));
    public static final By addressBookSortNameCol = getByLocator(LocatorManager.getLocatorInfo("addressBookSortNameCol"));
    public static final By addressBookFirstNameCol = getByLocator(LocatorManager.getLocatorInfo("addressBookFirstNameCol"));
    public static final By addressBookSortDepartmentCol = getByLocator(LocatorManager.getLocatorInfo("addressBookSortDepartmentCol"));
    public static final By addressBookSortDepartmentColDesc = getByLocator(LocatorManager.getLocatorInfo("addressBookSortDepartmentColDesc"));
    public static final By addressBookSortDepartmentColDefault = getByLocator(LocatorManager.getLocatorInfo("addressBookSortDepartmentColDefault"));
    public static final By addressBookFirstDepartmentCol = getByLocator(LocatorManager.getLocatorInfo("addressBookFirstDepartmentCol"));


    /**
     * Highlighting Elements
     */
    public static final By highlightChargeType = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightChargeType")));
    public static final By highlightBaseCurrency = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightBaseCurrency")));
    public static final By highlightGSTApplicableYes = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightGSTApplicableYes")));
    public static final By highlightGSTApplicableNo = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightGSTApplicableNo")));
    public static final By highlightGLNumber = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightGLNumber")));
    public static final By highlightRefundable = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightRefundable")));
    public static final By highlightTagToRegistrationYes = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightTagToRegistrationYes")));
    public static final By highlightTagToRegistrationNo = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightTagToRegistrationNo")));
    public static final By highlightProfitCentre = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("highlightProfitCentre")));
    public static final By mainLayout = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("mainLayout")));
    public static final By createLayout = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("createLayout")));
    public static final By tableLayout = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("tableLayout")));
    public static final By itemPerRow = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("itemPerRow")));
    public static final By filterActive = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("filterActive")));
    public static final By filterInactive = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("filterInactive")));
    public static final By searchBar = getByLocator(Objects.requireNonNull(LocatorManager.getLocatorInfo("searchBar")));
    public static final By toastMessageNotificationBox = getByLocator(LocatorManager.getLocatorInfo("toastMessageNotificationBox"));
    public static final By addressBookModal = getByLocator((LocatorManager.getLocatorInfo("addressBookModal")));



    /**
     * Method to get a By locator based on the type and value provided.
     *
     * @param type  The type of locator (id, name, xpath, cssSelector, className, tagName, linkText, partialLinkText)
     * @param value The locator value
     * @return The By locator
     */

    // For single LocatorInfo
    public static By getByLocator(LocatorManager.LocatorInfo locatorInfo) {
        try {
            String locatorType = locatorInfo.getLocatorType();
            String locatorValue = locatorInfo.getLocatorValue();

            switch (locatorType.toLowerCase()) {
                case "id":
                    return By.id(locatorValue);
                case "name":
                    return By.name(locatorValue);
                case "xpath":
                    return By.xpath(locatorValue);
                case "cssselector":
                    return By.cssSelector(locatorValue);
                case "classname":
                    return By.className(locatorValue);
                case "tagname":
                    return By.tagName(locatorValue);
                case "linktext":
                    return By.linkText(locatorValue);
                case "partiallinktext":
                    return By.partialLinkText(locatorValue);
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locatorType);
            }
        } catch (Exception e) {
            // Log or handle the exception if necessary
            throw new IllegalArgumentException("Error getting locator: " + e.getMessage());
        }
    }

    // For list of LocatorInfo
    public static By getByLocator(List<LocatorManager.LocatorInfo> locatorInfos) {
        try {
            for (LocatorManager.LocatorInfo locatorInfo : locatorInfos) {
                String locatorType = locatorInfo.getLocatorType();
                String locatorValue = locatorInfo.getLocatorValue();

                switch (locatorType.toLowerCase()) {
                    case "id":
                        return By.id(locatorValue);
                    case "name":
                        return By.name(locatorValue);
                    case "xpath":
                        return By.xpath(locatorValue);
                    case "cssselector":
                        return By.cssSelector(locatorValue);
                    case "classname":
                        return By.className(locatorValue);
                    case "tagname":
                        return By.tagName(locatorValue);
                    case "linktext":
                        return By.linkText(locatorValue);
                    case "partiallinktext":
                        return By.partialLinkText(locatorValue);
                    default:
                        throw new IllegalArgumentException("Invalid locator type: " + locatorType);
                }
            }
        } catch (Exception e) {
            // Log or handle the exception if necessary
            throw new IllegalArgumentException("Error getting locator: " + e.getMessage());
        }

        throw new IllegalArgumentException("No valid locators found");
    }



//    public static By getByLocator(LocatorManager.LocatorInfo locatorInfo) {
//        String type = locatorInfo.getLocatorType();
//        String value = locatorInfo.getLocatorValue();
//
//        switch (type.toLowerCase()) {
//            case "id":
//                return By.id(value);
//            case "name":
//                return By.name(value);
//            case "xpath":
//                return By.xpath(value);
//            case "cssselector":
//                return By.cssSelector(value);
//            case "classname":
//                return By.className(value);
//            case "tagname":
//                return By.tagName(value);
//            case "linktext":
//                return By.linkText(value);
//            case "partiallinktext":
//                return By.partialLinkText(value);
//            default:
//                throw new IllegalArgumentException("Invalid locator type: " + type);
//        }
//    }

}
