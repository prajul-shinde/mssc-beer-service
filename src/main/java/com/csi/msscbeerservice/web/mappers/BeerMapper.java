package com.csi.msscbeerservice.web.mappers;

import com.csi.msscbeerservice.domain.Beer;
import com.csi.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
