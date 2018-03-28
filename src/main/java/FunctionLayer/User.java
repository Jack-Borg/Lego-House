package FunctionLayer;

/**
 * The purpose of User is to...
 *
 * @author kasper
 */
public class User
{

    private int id;
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRole()
    {
        return role;
    }

}
