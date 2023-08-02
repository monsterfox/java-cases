package config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ResourceBundle;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //return new String[]{"com.foxbill.dao.impl.BookDaoImpl"};

        /*
        ResourceBundle bundle = ResourceBundle.getBundle("import");
        String className = bundle.getString("className");
        return new String[]{className};
        */

        ResourceBundle bundle = ResourceBundle.getBundle("import");
        String className = bundle.getString("className");
        return className.split(",");

    }
}
