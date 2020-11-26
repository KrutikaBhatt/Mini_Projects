/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.management;


class User {

   private String voterid,password,name,Aadhar_no,address,sex;
    int age;
    
    public User (String voterid,String password,String name,String fathername,String address,String sex,int age)
            {
            this.voterid=voterid;
            this.password=password;
            this.address=address;
            this.name=name;
            this.Aadhar_no=Aadhar_no;
            this.sex=sex;
            this.age=age;
            
            }
    public String getvoterid()
    {
    return voterid;}
    public String getpassword()
    {
    return password;
    }
    public String getname()
    {
    return name;}
    public String getfathername()
    {
    return Aadhar_no;}
    public String getsex()
    {
    return sex;
    
    }
    public int getage()
    {
    return age;
    }
    public String getaddress()
    {
    return address;
    
    }

    
    
}
