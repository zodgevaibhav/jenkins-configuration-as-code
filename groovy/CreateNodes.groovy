import hudson.model.Node.Mode
import hudson.slaves.*
import jenkins.model.Jenkins

String agentList = "10.100.64.64"
String agentDescription = "Selenium Chrome Slave"
String agentHome = "c:\\selenium"
String agentExecutors = "1"

agentList.eachLine
{
	DumbSlave slave = new DumbSlave(it,
	agentDescription,
	agentHome,
	agentExecutors,
	Mode.EXCLUSIVE,
	"",
	new JNLPLauncher(),
	RetentionStratergy.INSTANCE)
	
	Jenkins.instance.addNode(slave)
}