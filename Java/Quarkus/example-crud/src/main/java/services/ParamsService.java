package services;

import java.lang.reflect.Field;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domains.Param;
import domains.Params;

@ApplicationScoped
public class ParamsService {

    public List<Params> getAllParams() {
        return Params.listAll();
    }

    public Params findParamsById(String paramsId) {
        return Params.findById(paramsId);
    }

    public Params createParams(Params params) {
        Params.persist(params);
        return params;
        
    }

    public Params updateParams(Params params) {

        Params.update(params);
        return this.findParamsById(params.getId());
    }

    public void deleteParams(String paramsId) {

        Params.deleteById(paramsId);
    }

    public List<Param> findParamByIdAndName(String paramsId, String paramName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
       
        Params params = this.findParamsById(paramsId);
        
        Object object = params;
        Class<?> clss = object.getClass();
        Field fld = clss.getDeclaredField(paramName);
        fld.setAccessible(true);

        List<Param> values = (List<Param>) fld.get(object);
        
        return values;
    }


}
