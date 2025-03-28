import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static RequestSpecification setupRequestSpec;
    protected static RequestSpecification urlencodedSetupSpec;
    protected static ResponseSpecification setupResponseSpec;

    @BeforeClass
    protected  void setupSpecInit() {
        setupRequestSpec = RequestSpecSetup.setupRequestSpec();
    }

    @BeforeClass
    protected  void urlencodedSetupSpecInit() {
        urlencodedSetupSpec = RequestSpecSetup.urlencodedSetupRequestSpec();
    }

    @BeforeClass
    protected  void setupResponseSpecBuilder() {
        setupResponseSpec = ResponseSpecSetup.setupResponseSpec();
    }
}