package org.codehaus.modello.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Creates an XPP3 extended writer from the model. An extended writer renders
 * the content with comments about the line/column from which the data was read
 * if the model supports this.
 *
 * @author Hervé Boutemy
 * @since 1.10
 */
@Mojo(name = "xpp3-extended-writer", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class ModelloXpp3ExtendedWriterMojo extends AbstractModelloXpp3ExtendedWriterMojo {
  @Override
  protected String getGeneratorType() {
    return "xpp3-extended-writer";
  }

}
