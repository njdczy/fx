package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Region;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * @author zhenggg on 2017/5/8.
 */
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{
        private File regionFile;

    public void setRegionFile(File regionFile) {
        this.regionFile = regionFile;
    }

    /**
     * 区域导入
     */
    public  String importXls() {
        new HSSFWorkbook();
        return NONE;
    }
}
