# modello-usurped

## What The H*SCK?!?!

This project was initially forked off of [Codehaus Modello](https://codehaus-plexus.github.io/modello/) version 1.11.

Modello is an excellent code generator and InfrastructureBuilder uses it extensively.


## Why The H*CK?!?!

OK, so this is a little complicated.

Modello has some deficiencies.  Like any jillion year old piece of software, it was written before all the cool kids came along.  Note that this allows all these cool
kids to stand on it's very sturdy shoulders, but that's a discussion for another time.

Modello uses an XML model to describe a data persistence and access mechanism.
In this way, it's much like other mechanisms, such as Avro or Protocol Buffers (which we also use).
Modello produces very boring JavaBeans that are used in its other generated code for persistence.

### The Problem

This XML model has the ability to indicate that the generation should not produce getters for the generated model entities.

However, it has a [bug](https://github.com/codehaus-plexus/modello/issues/34) that causes it to use those getters even when it very well knows they aren't being generated.

Given historical difficulty in getting changes introduced into Codehaus/Apache applications, we usurped and extended the codebase in order to solve the interim problem.

Initially, it looked like the only requirement would be to write a different component, and that might still be possible.  But it got boring so we just brute-forced a
solution that seems to work.

### But Why Not Just Submit a PR to Modello?

See above in re: historical difficulty.  It's not that IB is unwilling to do that.  It's just that we know how long that will take and how much back-and-forth and
reformatting of code and writing tests with specific names and sacrificing of chickens this will take.

### You're Not Being A Good Contributor

Yup.  We hope you haven't had the negative experiences we have in dealing with submissions to Open Source code.  You're probably happier for it.


## How do I use it?

It's Maven.  If you don't like that, feel free to try some other solution.  But if you need this plugin, it's probably because you understand why you
use Maven to do builds and why the boring output of Modello is nice.

Use the usurped plugin just like Modello, but in addition to Modello.
Use the `xpp3-writer-reflect` or `xpp-writer-extended-reflect` goal in the usurped plugin instead of `xpp3-writer` or `xpp3-writer-extended` in the basic Modello run.

This plugin generates code in the same place, so it'll produce the `*Xpp3Writer*` in the same place by default.

You can find an example of how this is used in the `pom.xml` of `ibdata-api` module of [this project](https://github.com/infrastructurebuilder/ibdata-api-root).

Issues will be considered.
