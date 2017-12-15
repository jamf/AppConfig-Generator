# AppConfig Generator

The AppConfig Generator is a tool which assists in the generation of a configuration plist for a mobile app on a device enrolled in an MDM solution.

The AppConfig Generator takes in a spec file which can either be created by hand, through the use of the [AppConfig Spec Creator](https://github.com/jamf/AppConfigSpecCreator), or selected from the repository of existing spec files. 

It will then display a form with areas to fill out with the configuration values you would like the app to have.

Once you configure the values you want, you can download the plist from the AppConfig Generator and upload it to your MDM provider so it can be installed onto the device. 

You can view the [AppConfig Spec Reference](https://storage.googleapis.com/appconfig-media/appconfig-content/uploads/2017/01/ManagedAppConfig.pdf) for how documentation on how these spec files are formatted.

More information about AppConfig can be found at: [appconfig.org](https://appconfig.org/)

## Build & Run the AppConfig Generator
1. Using Maven: ```mvn package```
2. Output: ```target/managedAppConfigIngestor.war```
3. Deploy war using tomcat