import jenkins.model.*

def jobName = "cordova-project-android"
def configXml = "<?xml version='1.1' encoding='UTF-8'?> <project>   <actions/>   <description></description>   <keepDependencies>false</keepDependencies>   <properties/>   <scm class=\"hudson.scm.NullSCM\"/>   <assignedNode>CORDOVA_WINDOWS</assignedNode>   <canRoam>false</canRoam>   <disabled>false</disabled>   <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>   <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>   <triggers/>   <concurrentBuild>false</concurrentBuild>   <builders>     <hudson.tasks.BatchFile>       <command>SET JAVA_HOME=C:\\jdk1.8.0_151&#xd; e:&#xd; cd E:\\ALL_GIT_REPO\\Hive\\HiveUI&#xd; cordova build --verbose</command>     </hudson.tasks.BatchFile>   </builders>   <publishers/>   <buildWrappers/> </project>" // your xml goes here

def xmlStream = new ByteArrayInputStream( configXml.getBytes() )

Jenkins.instance.createProjectFromXML(jobName, xmlStream)