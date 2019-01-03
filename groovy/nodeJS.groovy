import hudson.model.*
import hudson.tools.*
import jenkins.plugins.nodejs.tools.*
import jenkins.model.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor(jenkins.plugins.nodejs.tools.NodeJSInstallation)

def installer = new NodeJSInstaller("NodeJS version", "some npm package", 1)
def prop = new InstallSourceProperty([installer])
def sinst = new NodeJSInstallation("Ubuntu NodeJS-6.5.0", "/usr/local/lib/node_modules/npm",[prop])

desc.setInstallations(sinst)

desc.save()