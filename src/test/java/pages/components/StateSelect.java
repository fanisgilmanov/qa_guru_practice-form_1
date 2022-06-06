package pages.components;
import static com.codeborne.selenide.Selenide.$;
public class StateSelect {
    public void setSelect (String input, String value) {
        $(input).setValue(value).pressEnter();
    }
}
