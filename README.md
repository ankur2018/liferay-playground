Liferay Playground
==================

A couple very basic Liferay Plugin examples generated with the Liferay Maven
Archetypes.

You don't need to install the Liferay Maven SDK if you only need to build and
deploy the examples. Maven is enough for that. The SDK is only needed to
create the basic skeleton for your own portlets, hooks, etc by running the
archetype:generate goal.

## Prerequisites

  - JDK 1.6+
  - Apache Maven 3.0.4+
  - Apache Ant 1.8.2+ (required to install the SDK)

## Installing the Liferay Maven SDK

Download the [Liferay Maven SDK]. I found the download link in this [blog
entry].

    $ unzip liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip
    $ cd liferay-portal-maven-6.1.0
    $ ant install

Now you can use:

    $ mvn archetype:generate -Dfilter=com.liferay:liferay

This will give you a list of Liferay Maven Archetypes to choose from and
further prompts will guide you through the necessary steps.

Or you can enter all required parameters from the command line like this:

    $ mvn archetype:generate # TODO: fixme

[Liferay Maven SDK]: http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.1.0%20GA1/liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip/download
[blog entry]: http://www.liferay.com/web/mika.koivisto/blog/-/blogs/12034718
