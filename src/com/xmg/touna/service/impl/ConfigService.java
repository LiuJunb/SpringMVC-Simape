package com.xmg.touna.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xmg.touna.base.BaseDAO;
import com.xmg.touna.model.Config;
import com.xmg.touna.service.IConfigService;
@Service("configService")
public class ConfigService extends BaseDAO<Config>implements IConfigService {
	
}
