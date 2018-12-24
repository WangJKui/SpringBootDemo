package ${package_name}.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：${table_annotation}的VO对象
 * @author ${author}
 * @date ${date}
 */
public class ${table_name} implements Serializable {

	private static final long serialVersionUID = 1L;
	
    <#if model_column?exists>
    <#list model_column as model>
	/**
	 *${model.columnComment!}
	 */
	<#if (model.columnType?lower_case == 'varchar' || model.columnType?lower_case == 'text')>
	private String ${model.changeColumnName?uncap_first};
	<#elseif (model.columnType?lower_case == 'timestamp'|| model.columnType?lower_case == 'date') >
	private Date ${model.changeColumnName?uncap_first};
	<#else>
	private Integer ${model.changeColumnName?uncap_first};
    </#if>
	</#list>
    </#if>

<#if model_column?exists>
<#list model_column as model>
<#if (model.columnType?lower_case == 'varchar' || model.columnType?lower_case == 'text')>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
<#elseif (model.columnType?lower_case == 'timestamp'|| model.columnType?lower_case == 'date') >
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
<#else>
	public Integer get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Integer ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
</#if>
</#list>
</#if>

}