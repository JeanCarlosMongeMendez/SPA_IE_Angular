package cr.ac.ucr.spa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

import java.util.List;
import java.util.stream.Collectors;

public class KendoDropdown {


    public class KendoDropdwon {

        WebDriver driver;
        String name;
        WebElement parentElem;

        public KendoDropdwon(WebElement parentElem) {
            this.parentElem = parentElem;
            name = parentElem.getAttribute("aria-owns");
            this.driver = ((WrapsDriver) parentElem).getWrappedDriver();

        }

        /**
         * Returns selected item from the Dropdown
         * @return
         */
        public String getSelection() {
            return parentElem.findElement(By
                    .cssSelector("span.k-state-default span.k-input"))
                    .getText();
        }

        /**
         * Retruns all options displayed on the Dropdown
         * @return list of options
         */
        public List<String> getOptions() {
            expand();
            List<String> options = driver.findElements(By.cssSelector("ul#" + name + " li"))
                    .stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            collapse();
            return options;
        }

        /**
         * Returns count of options
         * @return
         */
        public int getSize() {
            //expand();
            int size = driver.findElements(By.cssSelector("ul#" + name + " li")).size();
            //collapse();
            return size;
        }

        /**
         * Select item in the Dropdown
         * @param item text
         */
        public void selectItem(String item) {
            expand();
            driver.findElement(By.cssSelector("ul#" + name))
                    .findElement(By.xpath("./li[text()='" + item + "']")).click();
            collapse();
        }

        /**
         * Open Dropdown
         */
        private void expand() {
            if (!parentElem.getAttribute("aria-expanded").equals("true")) {
                parentElem.findElement(By.cssSelector("span.k-icon")).click();
            }
        }

        /**
         * Close Dropdown
         */
        private void collapse() {
            if (!parentElem.getAttribute("aria-expanded").equals("false")) {
                parentElem.findElement(By.cssSelector("span.k-icon")).click();
            }
        }
    }
}
