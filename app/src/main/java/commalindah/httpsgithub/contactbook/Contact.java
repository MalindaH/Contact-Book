package commalindah.httpsgithub.contactbook;

public class Contact
{
    private String name;
    private String phone;
    private String email;

    /**
     * Contact sets class-level variables name, phone, and email to be empty strings
     *
     * @param "" There are no parameters
     * @return Nothing is returned
     */
    public Contact()
    {
        name = "";
        phone = "";
        email = "";
    }

    /**
     * Contact sets class-level variables name, phone, and email to their corresponding parameters
     *
     * @param nameInput is the input of name
     * @param phoneInput is the input of phone
     * @param emailInput is the input of email
     * @return Nothing is returned
     */
    public Contact( String nameInput, String phoneInput, String emailInput )
    {
        name = nameInput;
        phone = phoneInput;
        email = emailInput;
    }

    /**
     * getName is the method used to get the name of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' names
     */
    public String getName()
    {
        return name;
    }

    /**
     * getName is the method used to get the phone of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' phones
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * getName is the method used to get the email of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' emails
     */
    public String getEmail()
    {
        return email;
    }

}
