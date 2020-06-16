package com.lugew.winsim.codegenerator.core;

import java.util.List;

/**
 * 代码生成器
 *
 * @author LuGew
 * @since 2020/5/31
 */
public interface CodeGenerator {

    String getEntityName();

    void setEntityName(String entityName);

    void generate(List<TemplateProperty> templateProperties);

    String getTargetPath();

    void setTargetPath(String targetPath);
}
