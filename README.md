[![Build Status](https://travis-ci.org/serinth/stackdriver-debugger-example.svg?branch=master)](https://travis-ci.org/serinth/stackdriver-debugger-example.svg?branch=master)

# Debugging Applications in Production with Google Cloud Debugger

This example shows how a Java Spring Boot application can be debugged using Google's Cloud Debugger even if the executable is running on a different environment e.g. AWS. The appeal of this is the ability to debug in production and without sharing all the source code with another cloud provider. 

More detailed instructions can be found here at this blog post: [Debugging Java in Production](http://www.tonytruong.net/debugging-java-apps-in-production/)

# Requirements

- At least Java 7 for the agent. This example will run Java 8.
- Linux - the agent only installs on Linux at the moment
- Java application (GCP supports Python, Go and Java)
- Maven
- A Google Account registered with the free trial

# 1. Compile And Package This Application
```bash
mvn clean install spring-boot:repackage
```

# 2. Install the Java Debugger Agent

[Java Cloud Debugger Agent](https://github.com/GoogleCloudPlatform/cloud-debug-java/blob/master/README.md)


# References

[Google Cloud Debugger](https://cloud.google.com/debugger/)

[Java Cloud Debugger Agent](https://github.com/GoogleCloudPlatform/cloud-debug-java/blob/master/README.md)

