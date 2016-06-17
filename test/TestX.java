import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.workitem.WorkItem;
import com.microsoft.tfs.core.clients.workitem.WorkItemClient;
import com.microsoft.tfs.core.clients.workitem.project.Project;
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;
import junit.framework.TestCase;


public class TestX extends TestCase {




    // assigning the values
    protected void setUp(){
    }

    // test method to add two values
    public void testAdd(){
        TFSTeamProjectCollection tpc =  ConnectionFactory.connectToTFS();


        Project project = tpc.getWorkItemClient().getProjects().get("TIA");
        WorkItemClient workItemClient = project.getWorkItemClient();


        // Define the WIQL query.
        String wiqlQuery = "Select ID, Title from WorkItems where (State = 'Active') AND ([System.AreaPath] UNDER 'TIA\\Development\\TIA Portal\\Feature Teams\\Multiuser') order by Title";


        // Run the query and get the results.
        WorkItemCollection workItems = workItemClient.query(wiqlQuery);


        System.out.println("Found " + workItems.size() + " work items.");

        System.out.println();


        // Write out the heading.
        System.out.println("ID\tTitle");


        // Output the first 20 results of the query, allowing the TFS SDK to page
        // in data as required

        final int maxToPrint = 20;

        for (int i = 0; i < workItems.size(); i++)
        {

            if (i >= maxToPrint)
            {

                System.out.println("[...]");
                break;

            }


            WorkItem workItem = workItems.getWorkItem(i);

            System.out.println(workItem.getID() + "\t" + workItem.getTitle());
        }

    }
}
