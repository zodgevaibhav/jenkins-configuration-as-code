import hudson.model.JDK
import hudson.tools.InstallSourceProperty
import hudson.tools.ZipExtractionInstaller

def descriptor = new JDK.DescriptorImpl();

new AntBuilder.copy(todir:'/var/jenkins_hime/plugins')
{
	fileset(dir:'/usr/share/jenkins/jenkins_home/plugins')
}

def List<JDK> installation=[]

javaTools=[['name':'jdk8','url':'file:/var/jenkins_home/downloads/jdk-8u172-linux-x64.tar.gz','subdir':'jdk1.8.0_131']]

javaTools.each
{
	javaTool->
		println("Setting up jdk:${javaTool.name}")
		
		def installer = new ZipExtractionInstaller(javaTool.label as String, javaTool.url as String, javaTool.subdir as String);
		def jdk = new JDK(javaTool.name as String, null, [new InstallSourceProperty([installer])])
		installation.add(jdk)
}

descriptor.setInstallations(installations.toArray(new JDK[installation.size()]))
descriptor.save()