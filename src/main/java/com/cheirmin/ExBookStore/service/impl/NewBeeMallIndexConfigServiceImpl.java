package com.cheirmin.ExBookStore.service.impl;

import com.cheirmin.ExBookStore.common.ServiceResultEnum;
import com.cheirmin.ExBookStore.controller.vo.NewBeeMallIndexConfigGoodsVO;
import com.cheirmin.ExBookStore.dao.IndexConfigMapper;
import com.cheirmin.ExBookStore.dao.NewBeeMallGoodsMapper;
import com.cheirmin.ExBookStore.entity.IndexConfig;
import com.cheirmin.ExBookStore.entity.NewBeeMallGoods;
import com.cheirmin.ExBookStore.service.NewBeeMallIndexConfigService;
import com.cheirmin.ExBookStore.util.BeanUtil;
import com.cheirmin.ExBookStore.util.PageQueryUtil;
import com.cheirmin.ExBookStore.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {

    @Autowired
    private IndexConfigMapper indexConfigMapper;

    @Autowired
    private NewBeeMallGoodsMapper goodsMapper;

    @Override
    public PageResult getConfigsPage(PageQueryUtil pageUtil) {
        List<IndexConfig> indexConfigs = indexConfigMapper.findIndexConfigList(pageUtil);
        int total = indexConfigMapper.getTotalIndexConfigs(pageUtil);
        PageResult pageResult = new PageResult(indexConfigs, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveIndexConfig(IndexConfig indexConfig) {
        //todo 判断是否存在该商品
        if (indexConfigMapper.insertSelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateIndexConfig(IndexConfig indexConfig) {
        //todo 判断是否存在该商品
        IndexConfig temp = indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (indexConfigMapper.updateByPrimaryKeySelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public IndexConfig getIndexConfigById(Long id) {
        return null;
    }

    @Override
    public List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number) {
        List<NewBeeMallIndexConfigGoodsVO> newBeeMallIndexConfigGoodsVOS = new ArrayList<>(number);
        List<IndexConfig> indexConfigs = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
        if (!CollectionUtils.isEmpty(indexConfigs)) {
            //取出所有的goodsId
            List<Long> goodsIds = indexConfigs.stream().map(IndexConfig::getGoodsId).collect(Collectors.toList());
            List<NewBeeMallGoods> newBeeMallGoods = goodsMapper.selectByPrimaryKeys(goodsIds);
            newBeeMallIndexConfigGoodsVOS = BeanUtil.copyList(newBeeMallGoods, NewBeeMallIndexConfigGoodsVO.class);
            for (NewBeeMallIndexConfigGoodsVO newBeeMallIndexConfigGoodsVO : newBeeMallIndexConfigGoodsVOS) {
                String goodsName = newBeeMallIndexConfigGoodsVO.getGoodsName();
                String goodsIntro = newBeeMallIndexConfigGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 30) {
                    goodsName = goodsName.substring(0, 30) + "...";
                    newBeeMallIndexConfigGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 22) {
                    goodsIntro = goodsIntro.substring(0, 22) + "...";
                    newBeeMallIndexConfigGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        return newBeeMallIndexConfigGoodsVOS;
    }

    @Override
    public Boolean deleteBatch(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除数据
        return indexConfigMapper.deleteBatch(ids) > 0;
    }
}
