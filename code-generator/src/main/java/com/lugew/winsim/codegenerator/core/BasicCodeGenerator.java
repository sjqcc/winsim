package com.lugew.winsim.codegenerator.core;

/**
 * @author LuGew
 * @since 2020/6/1
 */
public class BasicCodeGenerator extends AbstractCodeGenerator {
    private static final String DEFAULT_TEMPLATE_DIRECTORY = "templates";


    public BasicCodeGenerator() {
        super(DEFAULT_TEMPLATE_DIRECTORY);
    }

    public BasicCodeGenerator(String templateDirectory) {
        super(templateDirectory);
    }

    public BasicCodeGenerator(String entityName, String targetPath) {
        this(entityName, DEFAULT_TEMPLATE_DIRECTORY, targetPath);
    }

    public BasicCodeGenerator(String entityName, String templateDirectory, String targetPath) {
        super(templateDirectory);
        setEntityName(entityName);
        setTargetPath(targetPath);
    }
}
