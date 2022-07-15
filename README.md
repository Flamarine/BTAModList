# BTA Example Mod - Babric

A simple mod template for Better Than Adventure, yet this template is for Babric.

Original version: https://github.com/pkstDev/BTAExampleMod

### Setup (Same as the original one)

1. Grab a full BTA jar from the MultiMC instance (or anywhere else you want) and rename it to "bta.jar".

2. Place the jar in the "libs" folder in your project.

3. Run the following command:
```shell
gradlew build
```

4. Start your modding trip!

### Extra Tips

Since BTA is distributed without obfuscation, all Mixin classes must set the 'remap' option to false!
