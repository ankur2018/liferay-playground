Liferay Playground
==================

A couple very basic Liferay Plugin examples generated with Liferay Maven Archetypes.

## Prerequisites

  - JDK 1.6+
  - Apache Maven 3.0.4+
  - Apache Ant 1.8.2+

## Installing the Liferay Maven SDK

Download the [Liferay Maven SDK]. I found the download link in this [blog entry].

    $ unzip liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip
    $ cd liferay-portal-maven-6.1.0
    $ ant install

Now you can use:

    $ mvn archetype:generate # type 'liferay' at the prompt to filter
                             # for liferay archetypes


[Liferay Maven SDK]: http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.1.0%20GA1/liferay-portal-maven-6.1.0-ce-ga1-20120106155615760.zip/download
[blog entry]: http://www.liferay.com/web/mika.koivisto/blog/-/blogs/12034718