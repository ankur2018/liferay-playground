Liferay Playground
==================

A couple very basic Liferay Plugin examples generated with the Liferay
Maven Archetypes.

You don't need to install the Liferay Maven SDK if you only need to
build and deploy the examples. Maven is enough for that. The SDK is
only needed to create the basic skeleton for your own portlets, hooks,
etc by running the archetype:generate goal.

## Prerequisites

  - JDK 1.6+
  - Apache Maven 3.0.4+
  - Apache Ant 1.8.2+ (required to install the SDK)

## Installing the Liferay Maven SDK

Download the [Liferay Maven SDK]. I found the download link in this
[blog entry].

    $ unzip liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip
    $ cd liferay-portal-maven-6.1.0
    $ ant install

Now you can use:

    $ mvn archetype:generate -Dfilter=com.liferay:liferay

This will give you a list of Liferay Maven Archetypes to choose from
and further prompts will guide you through the necessary steps.

Or you can enter all required parameters from the command line like
this:

    $ # for a portlet use:
    $ mvn archetype:generate \
       -DgroupId=com.nexse.swat.liferay.examples \
       -DartifactId=portlet-example \
       -Dversion=1.0.0-SNAPSHOT \
       -DpackageName=com.nexse.swat.liferay.examples.portlet.example \
       -DarchetypeGroupId=com.liferay.maven.archetypes \
       -DarchetypeArtifactId=liferay-portlet-archetype \
       -DarchetypeVersion=6.1.0 \
       -DinteractiveMode=false
    $ # for an hook use:
    $ mvn archetype:generate \
       -DgroupId=com.nexse.swat.liferay.examples \
       -DartifactId=hook-example \
       -Dversion=1.0.0-SNAPSHOT \
       -DpackageName=com.nexse.swat.liferay.examples.hook.example \
       -DarchetypeGroupId=com.liferay.maven.archetypes \
       -DarchetypeArtifactId=liferay-hook-archetype \
       -DarchetypeVersion=6.1.0 \
       -DinteractiveMode=false


## Deploying to Liferay

If you want to be able to invoke

    $ mvn liferay:deploy

add a custom liferay.auto.deploy.dir property in your ~/.m2/settings.xml,
like this:

    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          http://maven.apache.org/xsd/settings-1.0.0.xsd">
        <profiles>
            <profile>
                <id>liferay</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                </activation>
                <properties>
                    <liferay.auto.deploy.dir>/home/mcaserta/liferay/deploy</liferay.auto.deploy.dir>
                </properties>
            </profile>
        </profiles>
    </settings>


[Liferay Maven SDK]: http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.1.0%20GA1/liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip/download
[blog entry]: http://www.liferay.com/web/mika.koivisto/blog/-/blogs/12034718

