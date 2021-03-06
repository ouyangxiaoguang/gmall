package com.sz.gmall.cms.service;

import com.sz.gmall.cms.entity.PrefrenceArea;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 优选专区 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface PrefrenceAreaService extends IService<PrefrenceArea> {

    List<PrefrenceArea> findListByAll();
}
