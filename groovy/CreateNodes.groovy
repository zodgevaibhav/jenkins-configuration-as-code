import hudson.model.Node.Mode
import hudson.slaves.*
import jenkins.model.Jenkins

String agentList = "10.100.64.64"
String agentDescription = "Selenium Chrome Slave"
String agentHome = "c:\\selenium"
String agentExecutors = "1"

agentList.eachLine
{
    DumbSlave slave = new DumbSlave(it,  // Agent name, usually matches the host computer's machine name
            agentDescription,           // Agent description
            agentHome,                  // Workspace on the agent's computer
            agentExecutors,             // Number of executors
            Mode.EXCLUSIVE,             // "Usage" field, EXCLUSIVE is "only tied to node", NORMAL is "any"
            "",                         // Labels
            new JNLPLauncher(),         // Launch strategy, JNLP is the Java Web Start setting services use
            RetentionStrategy.INSTANCE) // Is the "Availability" field and INSTANCE means "Always"

    Jenkins.instance.addNode(slave)
	
}