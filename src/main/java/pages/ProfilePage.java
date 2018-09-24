package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.pe-hub-section__expand-button.pe-hub__action.button-primary-large.pe-hub-section__expand-button"
			+ "--v2-topcard")
	WebElement addProfileSectionButton;

	@FindBy (id = "background-drawer")
	WebElement backgroundSectionButton;
	
	@FindBy(id = "position-card")
	WebElement addExperienceButton;

	@FindBy(id = "position-title-typeahead")
	WebElement titleTextbox;

	@FindBy(id = "position-company-typeahead")
	WebElement companyTextbox;

	@FindBy(id = "position-start-month")
	WebElement startMonthJobDropdown;

	@FindBy(id = "position-start-year")
	WebElement startYearJobDropdown;

	@FindBy(id = "position-description")
	WebElement descriptionExperienceTextbox;

	@FindBy(xpath = "(//*[text()='Save'])[2]")
	WebElement saveButton;

	@FindBy(id = "education-card")
	WebElement addEducationButton;

	@FindBy(id = "edu-school-typeahead")
	WebElement schoolNameTextbox;

	@FindBy(id = "edu-degree-typeahead")
	WebElement bachelorTextbox;

	@FindBy(id = "edu-field-of-study-typeahead")
	WebElement studyFieldTextbox;

	@FindBy(id = "edu-grade")
	WebElement gradeTextbox;

	@FindBy(id = "intro-drawer")
	WebElement introSectionButton;

	@FindBy(id = "summary-card")
	WebElement addSummaryButton;

	@FindBy(id = "topcard-summary")
	WebElement summaryTextbox;
	
	@FindBy (id = "accomplishments-drawer")
	WebElement accomplishmentsSectionButton;
	
	@FindBy (id = "course-card")
	WebElement addCourseButton;

	@FindBy (id = "course-name")
	WebElement courseNameTextbox;
	

	public void openAddExperiencePopup() {

		clickButton(addProfileSectionButton);
		clickButton(backgroundSectionButton);
		clickButton(addExperienceButton);
	}

	public void addExperience(String Title, String Company, String Month, String Year, String Description)
			throws InterruptedException {

		Thread.sleep(2000);
		setTextValue(titleTextbox, Title);
		setTextValue(companyTextbox, Company);
		selectFromDropdown(startMonthJobDropdown, Month);
		selectFromDropdown(startYearJobDropdown, Year);
		setTextValue(descriptionExperienceTextbox, Description);
		clickButton(saveButton);
		Thread.sleep(5000);

	}

	public void openAddEducationPopup() {

		clickButton(addProfileSectionButton);
		//clickButton(backgroundSectionButton);
		clickButton(addEducationButton);
	}

	public void addEducation(String schoolName, String bachelor, String studyField, String grade)
			throws InterruptedException {

		Thread.sleep(2000);
		setTextValue(schoolNameTextbox, schoolName);
		setTextValue(bachelorTextbox, bachelor);
		setTextValue(studyFieldTextbox, studyField);
		setTextValue(gradeTextbox, grade);
		clickButton(saveButton);
		Thread.sleep(5000);

	}

	public void openProfileSummarySectionPopup() {

		clickButton(addProfileSectionButton);
		clickButton(introSectionButton);
		clickButton(addSummaryButton);
	}

	public void addSummaryForProfile(String summary) throws InterruptedException {

		Thread.sleep(2000);
		setTextValue(summaryTextbox, summary);
		clickButton(saveButton);
		Thread.sleep(3000);

	}
	
	public void openAddCoursePopup() {

		clickButton(addProfileSectionButton);
		clickButton(accomplishmentsSectionButton);
		clickButton(addCourseButton);
	}
	
	public void addCourse(String Course) throws InterruptedException {

		Thread.sleep(2000);
		setTextValue(courseNameTextbox, Course);
		clickButton(saveButton);
		Thread.sleep(3000);

	}
}
