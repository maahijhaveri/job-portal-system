import java.util.*;

// Job class
class Job {
    String title, company, description;

    Job(String title, String company, String description) 
    {
        this.title = title;
        this.company = company;
        this.description = description;
    }
 

}

// User class
class User
{
    String name, email;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
   
}
public class JobPortalSystem
 {
   static  Scanner sc=new Scanner(System.in);

    // All static arrays and counters
    static Job[] jobs = new Job[100];
    static User[] users = new User[100];
   
    static int jobCount = 0, userCount = 0, appCount = 0;

    // Post Job
    static void postJob()
     {
        System.out.print("Job Title: ");
        String title = sc.nextLine();
        System.out.print("Company: ");
        String comp = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();

  
        for (int i = 0; i < jobCount; i++) {
            if (jobs[i].title.equalsIgnoreCase(title) && jobs[i].company.equalsIgnoreCase(comp) && jobs[i].company.equalsIgnoreCase(desc))
             {
                System.out.println("Job already exists!");
                return;
            }
        }

        Job newJob = new Job(title, comp, desc);
        jobs[jobCount] = newJob;//stroing new job  in array 
        jobCount++;

        System.out.println("Job added!");
    }

    // Register User
   
    static void registerUser() 
    {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].email.equalsIgnoreCase(email)) 
            {
                System.out.println("User already registered!");
                sc.nextLine();
                return;
            }
        }

        users[userCount++] = new User(name, email);
        System.out.println("User registered!");
    }

    // Apply for Job
static void applyJob() 
{
    if (jobCount == 0)
     {
        System.out.println("No jobs available to apply!");
        return;
    }

    System.out.println("Available Jobs:");
    for (int i = 0; i < jobCount; i++)
     {
        System.out.println((i + 1) + "." + jobs[i].title + "   " + jobs[i].company + "   " + jobs[i].description);
    }

    System.out.print("Choose a job to apply (number): ");
    int choice = sc.nextInt();
    sc.nextLine(); 

     if (choice < 1 || choice > jobCount) 
     {
        System.out.println("Invalid job choice!");
        return;
    }

    System.out.println("Application submitted successfully!");
}
    // Search Jobs
    static void searchJobs()
     {
        System.out.print("Enter keyword: ");
        String key = sc.nextLine();
       int count=0;

        for (int i = 0; i < jobCount; i++)
         {
            if (jobs[i].title.startsWith(key) || jobs[i].company.startsWith(key)||jobs[i].description.startsWith(key))
             {
                System.out.println("JOB TITLE:"+jobs[i].title);
                  System.out.println("Company:"+jobs[i].company);
                    System.out.println("Description:"+jobs[i].description);
                    count++;
            }
        }

         if (count == 0) 
    {
        System.out.println("No jobs found.");
    }
    }

    
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("===== Job Portal =====");
            System.out.println("1. Post Job");
            System.out.println("2. Register User");
            System.out.println("3. Apply for Job");
            System.out.println("4. Search Jobs");
          
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            try 
        {
                switch (choice)
                {
                    case 1: 
                    postJob();
                     break;
                    case 2: 
                    registerUser();
                     break;
                    case 3:
                     applyJob();
                      break;
                    case 4:
                     searchJobs();
                      break;
               
                    case 5:
                     System.out.println("Exiting..."); 
                     break;
                    default:
                     System.out.println("Invalid choice!");
                      break;
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (choice != 5);

    }
}
