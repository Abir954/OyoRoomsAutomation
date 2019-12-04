package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OyoRoomsLandingPage {

    WebDriver driver=null;
    public OyoRoomsLandingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement HomeTown()
    {
        return driver.findElement(By.xpath("//*[@id='autoComplete__home']"));
    }

    public void EnterValueToHomeTown(String value)
    {
        HomeTown().isEnabled();
        HomeTown().sendKeys(value);
    }

    /*public void DateSelect()
    {
        //return driver.findElement(By.xpath("//*[contains(@class,'datePickerDesktop')]"));
        DateFormat dateFormat2 = new SimpleDateFormat("mm");
        Date date2 = new Date();

        String today = dateFormat2.format(date2);

        //find the calendar
        WebElement dateWidget = driver.findElement(By.className("datePickerPopUp"));
        //Select Month
        WebElement Month=null;
        List<WebElement> Monthheader=dateWidget.findElements(By.className("DateRangePicker__Month"));
        *//*for(int i=1;i<=Monthheader.size();i++) {
        if(i==Monthheader.size())
            Month=Monthheader.get(i);
        }*//*
        Month= Monthheader.get(Monthheader.size()-1);
        //Select Date
        List<WebElement> cols=Month.findElements(By.tagName("td"));
        List<WebElement> spans = new ArrayList<WebElement>();
        //Select Start Date
        for(WebElement cell :  cols)
        {
           List<WebElement> spanlist = cell.findElements(By.tagName("span"));
           for(WebElement span: spanlist)
           {
               spans.add(span);
           }
        }
        //Select End Date
        for(WebElement item :  spans)
        {
            if(item.getText().equalsIgnoreCase("4"))
            {
                item.click();
                break;
            }
        }

    }*/

    public void EnterDateValue(String startDate, String endDate)
    {
        WebElement DateBox= driver.findElement(By.xpath("//div[contains(@class,'datePickerDesktop--home')]"));
        DateBox.click();

        driver.findElement(By.xpath("//div[@class='DateRangePicker__Month']//span[text()='January']/../..//td[not(contains(@class,'otherMonth'))]//span[text()='"+startDate+"']/..")).click();
        driver.findElement(By.xpath("//div[@class='DateRangePicker__Month']//span[text()='January']/../..//td[not(contains(@class,'otherMonth'))]//span[text()='"+endDate+"']/..")).click();

    }

    public WebElement GuestRoomPicker()
    {
        return driver.findElement(By.xpath("//*[contains(@class,'guestRoomPicker')]"));

    }
    public void EnterGuestValue(String value)
    {
        driver.findElement(By.xpath("//div[contains(@class,'guestRoomPicker--home')]")).click();
        int guestNo = Integer.parseInt(value);
        for( int i=1;i<guestNo;i++)
        {
            driver.findElement(By.xpath("//span[contains(@class,'plus')]")).click();
        }
    }

    public WebElement SearchButton()
    {
        return driver.findElement(By.xpath("//button[contains(@class,'searchButton') and contains(text(),'Search')]"));
    }

    public void ClickOnSearchButton()
    {
        SearchButton().click();
    }
}
