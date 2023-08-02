package config.filter;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata cm = metadataReader.getClassMetadata();
        String className = cm.getClassName();
        if (className.equals("com.foxbill.service.impl.UserServiceImpl")){
            return true; //返回值true,表示拦截
        }
        return false;//返回值false,表示不拦截
    }
}
