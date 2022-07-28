package Test;

//import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Thomas on 2016-06-15.
 */
public class Test_ContactSearch extends BaseTestClass {

    @Test
    public void searchContact() {
        //Search for contact
        searchPage.search("Sara");

        //Verify result
        searchPage.assertSearchResult("Sara Alston");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Sara Alston");
    }
    /*@Test
    public void searchContact_1() {
        //Search for contact
        searchPage.search("Jenny");

        //Verify result
        searchPage.assertSearchResult("Jenny Cherry");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Jenny Cherry");
    }
    @Test
    public void searchContact_2() {
        //Search for contact
        searchPage.search("Nadia");

        //Verify result
        searchPage.assertSearchResult("Nadia Patten");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Nadia Patten");
    }
    @Test
    public void searchContact_3() {
        //Search for contact
        searchPage.search("Joy");

        //Verify result
        searchPage.assertSearchResult("Joy Stclair");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Joy Stclair");
    }

     */
}
