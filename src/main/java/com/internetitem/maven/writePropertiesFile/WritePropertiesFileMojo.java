package com.internetitem.maven.writePropertiesFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Create a Java Properties file
 * 
 * @author Adam Batkin <adam@batkin.net>
 *
 */
@Mojo(name = "write-properties-file")
public class WritePropertiesFileMojo extends AbstractMojo {

	/**
	 * File where the properties are saved
	 */
	@Parameter(property = "outputFile", required = true)
	private File outputFile;

	/**
	 * Properties to save
	 */
	@Parameter(property = "properties", required = true)
	private Properties properties;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Saving properties to file " + outputFile.getAbsolutePath());
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(outputFile);
			OutputStreamWriter writer = new OutputStreamWriter(out, Charset.forName("UTF-8"));
			properties.store(writer, "Generated by Maven");
			writer.close();
			out.close();
		} catch (IOException e) {
			throw new MojoFailureException("Unable to save properties to file " + outputFile.getAbsolutePath() + ": " + e.getMessage(), e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					// Ignore
				}
			}
		}
	}

}
