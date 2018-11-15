package com.csm.manager.cinema.dao;

import com.csm.manager.cinema.pojo.dto.PageInfo;
import com.csm.manager.cinema.pojo.po.CinemaPO;
import java.util.List;

public abstract interface CinemaMapper
{
    public abstract List<CinemaPO> selectCinema(PageInfo paramPageInfo);

    public abstract Long selectCount(PageInfo paramPageInfo);

    public abstract void deleteCinema(Integer paramInteger);

    public abstract void deleteALL(int[] paramArrayOfInt);

    public abstract void updateCinema(CinemaPO paramCinemaPO);

    public abstract void saveCinema(CinemaPO paramCinemaPO);
}
