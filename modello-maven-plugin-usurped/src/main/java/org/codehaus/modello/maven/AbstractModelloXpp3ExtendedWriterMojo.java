package org.codehaus.modello.maven;

import java.util.Properties;

import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.modello.ModelloParameterConstants;

public class AbstractModelloXpp3ExtendedWriterMojo extends ModelloXpp3WriterMojo {
  /**
   * The class name suffix for the generated writer.
   */
  @Parameter(defaultValue = "Ex")
  private String extendedClassnameSuffix;

  protected void customizeParameters(Properties parameters) {
    super.customizeParameters(parameters);

    if (extendedClassnameSuffix != null) {
      parameters.put(ModelloParameterConstants.EXTENDED_CLASSNAME_SUFFIX, extendedClassnameSuffix);
    }
  }

}
