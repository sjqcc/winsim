package com.lugew.winsim.codegenerator.core;

import com.google.common.base.CaseFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * 代码生成器
 *
 * @author LuGew
 * @since 2020/5/31
 */
@Slf4j
public abstract class AbstractCodeGenerator implements CodeGenerator {
    private static final String TEMPLATE_SUFFIX = ".ftl";
    private final Configuration configuration;
    private String targetPath;
    private String entityName;

    public AbstractCodeGenerator(String directory) {
        this.configuration = new Configuration(Configuration.VERSION_2_3_30);
        loadTemplates(directory);
    }

    @Override
    public String getEntityName() {
        return entityName;
    }

    @Override
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String getTargetPath() {
        return targetPath;
    }

    @Override
    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public void loadTemplates(String path) {
        try {
            configuration.setDirectoryForTemplateLoading(new ClassPathResource(path).getFile());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("path not exist:{}", path);
        }
    }


    @Override
    public void generate(List<TemplateProperty> templateProperties) {
        for (TemplateProperty templateProperty : templateProperties) {
            generate(templateProperty);
        }
    }

    public void generate(TemplateProperty templateProperty) {
        try {
            Template template = configuration.getTemplate(templateProperty.getName() + TEMPLATE_SUFFIX);
            Writer out = new FileWriter(targetPath + getEntityName() +
                    CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, templateProperty.getName()) +
                    templateProperty.getSuffix());
            template.process(templateProperty.getParameters(), out);
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            log.error("template not found:{}", e.getMessage());
        }
    }
}
