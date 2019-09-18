package com.webautomation.validation;


/**
 * A public enum that holds the Test User information for automating profile
 * creation in testing.
 * 
 *
 */
public enum Users {

	/**
	 * Test user for default cases with no restrictions
	 */
	TESTUSER,
	/**
	 * Test user for cases where you want to allow admin access
	 */
	TESTUSER_ADMIN,
	/**
	 * Test user for cases where you want to use the email as the ID
	 */
	TESTUSER_EMAILID,
	/**
	 * Test user for cases where you want to start the creation, populate
	 * everything, then cancel
	 */
	TESTUSER_CANCEL,
	/**
	 * Test user for cases where you want to allow admin access and use the
	 * email as the ID
	 */
	TESTUSER_ADMIN_EMAILID,
	/**
	 * Test user for cases where you want to allow admin access, populate, then
	 * cancel
	 */
	TESTUSER_ADMIN_CANCEL,
	/**
	 * Test user for cases where you want to use email as ID, populate, then
	 * cancel
	 */
	TESTUSER_EMAILID_CANCEL,
	/**
	 * Test user for cases where you are copying from an existing user to a new
	 * user
	 */
	TESTUSER_COPY;

	/* Variables that make up the test users */
	private final String uname;
	private final String fname;
	private final String lname;
	private final String email;
	private final String password1;
	private final String password2;
	private final String sixDigitPhone;
	private final String tenDigitPhone1;
	private final String tenDigitPhone2;
	private final String randomUsername;

	/* Construct the user for each case */
	Users() {
		this.uname = "UName";
		this.fname = "FNameTest";
		this.lname = "LNameTest";
		this.email = "testemail@wind.com";
		this.password1 = "TestPass1";
		this.password2 = "TestPass2";
		this.sixDigitPhone = "5555555";
		this.tenDigitPhone1 = "5555555555";
		this.tenDigitPhone2 = "5555555566";
		this.randomUsername = uname + (Math.random()*0.9999999);
	}

	public String getFirstName() {
		return this.fname;
	}

	public String getLastName() {
		return this.lname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUserName() {
		return this.uname;
	}

	public String getPassword1() {
		return this.password1;
	}

	public String getPassword2() {
		return this.password2;
	}

	public String getRandomUsername() {
		return this.randomUsername;
	}

	public String getsixDigitPhone() {
		return sixDigitPhone;
	}

	public String gettenDigitPhone1() {
		return tenDigitPhone1;
	}

	public String gettenDigitPhone2() {
		return tenDigitPhone2;
	}

	/**
	 * Creates a string with the user name + a random number. This can be used
	 * to generate local unique user names for testing
	 * 
	 * @return String
	 */
	public String createRandomUsername() {
		return this.uname + (Math.random()*0.9999999);
	}

	/**
	 * Checks to see if this is a TESTUSER_COPY
	 * 
	 * @return boolean
	 */
	public boolean isCopy() {
		return this.equals(Users.TESTUSER_COPY);
	}

	/**
	 * Checks to see if this is a TESTUSER_ADMIN, TESTUSER_ADMIN_CANCEL, or
	 * TESTUSER_ADMIN_EMAILID
	 * 
	 * @return boolean
	 */
	public boolean isAdmin() {
		return this.equals(Users.TESTUSER_ADMIN) || this.equals(Users.TESTUSER_ADMIN_CANCEL)
				|| this.equals(Users.TESTUSER_ADMIN_EMAILID);
	}

	/**
	 * Checks to see if this is a TESTUSER_EMAILID, TESTUSER_EMAILID_CANCEL,
	 * TESTUSER_ADMIN_EMAILID
	 * 
	 * @return boolean
	 */
	public boolean isEmail() {
		return this.equals(Users.TESTUSER_ADMIN_EMAILID) || this.equals(Users.TESTUSER_EMAILID)
				|| this.equals(Users.TESTUSER_EMAILID_CANCEL);
	}

	/**
	 * Verifies that this is anything except TESTUSER_EMAILID,
	 * TESTUSER_EMAILID_CANCEL, TESTUSER_ADMIN_EMAILID
	 * 
	 * @return boolean
	 */
	public boolean isNotEmail() {
		return !this.equals(Users.TESTUSER_ADMIN_EMAILID) && !this.equals(Users.TESTUSER_EMAILID)
				&& !this.equals(Users.TESTUSER_EMAILID_CANCEL);
	}

	/**
	 * Checks to see if this is a TESTUSER_CANCEL, TESTUSER_EMAILID_CANCEL,
	 * TESTUSER_ADMIN_CANCEL
	 * 
	 * @return boolean
	 */
	public boolean isCancel() {
		return this.equals(Users.TESTUSER_CANCEL) || this.equals(Users.TESTUSER_ADMIN_CANCEL)
				|| this.equals(Users.TESTUSER_EMAILID_CANCEL);
	}
}
