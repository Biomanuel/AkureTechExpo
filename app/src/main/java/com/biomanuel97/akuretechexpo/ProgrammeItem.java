package com.biomanuel97.akuretechexpo;

public class ProgrammeItem {
    public String itemTitle;
    public String itemInfo;
    public String itemDurationTime;

    public ProgrammeItem(String itemTitle, String itemInfo, String itemDurationTime) {
        this.itemTitle = itemTitle;
        this.itemInfo = itemInfo;
        this.itemDurationTime = itemDurationTime;
    }

    public ProgrammeItem(String rawProgrammeItem) {
        String[] broken = rawProgrammeItem.split(":");
        switch (broken.length) {
            case 1:
                this.itemDurationTime = broken[0].isEmpty() ? "Duration not Specified yet" : broken[0];
                break;
            case 2:
                this.itemDurationTime = broken[0].isEmpty() ? "Duration not Specified yet" : broken[0];
                this.itemTitle = broken[1].isEmpty() ? "No Programme Scheduled yet" : broken[1];
                break;
            case 3:
                this.itemDurationTime = broken[0].isEmpty() ? "Duration not Specified yet" : broken[0];
                this.itemTitle = broken[1].isEmpty() ? "No Programme Scheduled yet" : broken[1];
                this.itemInfo = broken[2].isEmpty() ? "Listen attentively for more details" : broken[2];
                break;
            default:
                new ProgrammeItem();
        }
    }

    private ProgrammeItem() {
    }

    //region Getters and Setters
    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getItemDurationTime() {
        return itemDurationTime;
    }

    public void setItemDurationTime(String itemDurationTime) {
        this.itemDurationTime = itemDurationTime;
    }

    //endregion

}
