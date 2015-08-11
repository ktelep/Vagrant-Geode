# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"

  config.vm.network "private_network", ip: "192.168.33.10"
  config.vm.network "public_network"

  config.vm.provider "virtualbox" do |v|
   v.gui = false
   v.name = "Geode1"
   v.memory = 3072
   v.cpus = 2 
  end

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  config.vm.provision "shell", inline: <<-SHELL
     sudo apt-get update
     sudo apt-get install -y git
     echo debconf shared/accepted-oracle-license-v1-1 select true | \
        sudo debconf-set-selections
     echo debconf shared/accepted-oracle-license-v1-1 seen true | \
        sudo debconf-set-selections
     sudo apt-get install python-software-properties
     sudo add-apt-repository ppa:webupd8team/java -y
     sudo apt-get update
     sudo apt-get install oracle-java7-installer -y
     git clone https://github.com/apache/incubator-geode.git
     cd incubator-geode
     ./gradlew build installDist
  SHELL
end
