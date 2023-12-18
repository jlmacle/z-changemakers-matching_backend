package cm.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project implements Comparable<Object>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private Integer id;
	
	@Column(name="project_name")
	private String name;

	@Column(name="mission_statement")
	private String missionStatement;

	@Column(name="project_description")
	private String description;

	@Column(name="project_start_date")
	private String startDate;

	@Column(name="project_end_date")
	private String endDate;

	@Column(name="project_status")
	private String status;

	@Column(name="project_representative")
	private String representative;

	@Column(name="project_representative_email")
	private String representativeEmail;

	@Column(name="project_representative_phone")
	private String representativePhone;

	@Column(name="project_representative_address")
	private String representativeAddress;

	@Column(name="project_representative_city")
	private String representativeCity;

	@Column(name="project_representative_country")
	private String representativeCountry;

	@Column(name="project_representative_postal_code")
	private String representativePostalCode;

	@Column(name="project_representative_province_region_state")
	private String representativeProvinceRegionState;

	@Column(name="project_website")
	private String website;

	@Column(name="project_representative_notes")
	private String representativeNotes;

	@OneToMany(targetEntity=SDGGoals.class,mappedBy="sdg_goal_id")
	private List<SDGGoals> sdgGoals;

	@OneToMany(targetEntity=Language.class,mappedBy="language_id")
	private List<Language> languages;

	@OneToMany(targetEntity=ProjectNeed.class,mappedBy="project_need_id")
	private List<ProjectNeed> projectNeeds;
	
	//  "The default constructor exists only for the sake of JPA. 
	//  You do not use it directly, so it is designated as protected"
	//  Source: https://spring.io/guides/gs/accessing-data-jpa/
	protected Project() {
		super();
	}

	public Project(Integer projectId, String projectName) {
		super();
		this.id = projectId;
		this.name = projectName;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setId(Integer projectId) {
		this.id = projectId;
	}

	public void setName(String projectName) {
		this.name = projectName;
	}

	public int compareTo(Object object)
	{
		return this.getName().compareTo( ((Project)object).getName());
	}
	
	
	@Override
	public boolean equals(Object object)
	{
		if (object == null) {return false;}

		if (object.getClass() != Project.class) {return false;}

		return this.getId().equals(((Project)object).getId()) && this.getName().equals(((Project)object).getName());
	}

	@Override
	public int hashCode()
	{
		return this.getId().hashCode() + 1000000*this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}
	
	
}
