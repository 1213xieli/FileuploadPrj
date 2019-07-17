drop table T_FILEINFO;

-- Create table
create table T_FILEINFO
(
  id          VARCHAR2(80) not null,
  title       VARCHAR2(200), --标题
  dataType    VARCHAR2(200), --数据类型
  fileType       VARCHAR2(200), --文件类型
  fileUrl        VARCHAR2(200), --文件URL
  fileName      VARCHAR2(200),--文件名称
  filePath        VARCHAR2(200),--文件路径
  fileSize        VARCHAR2(200),--文件大小
  remark        VARCHAR2(800),--备注
  pigFarmId        VARCHAR2(200),--猪场id
  pigFarmName        VARCHAR2(200),--猪场名称
  createtime  DATE,--创建时间
  isenabled VARCHAR2(200),-- 是否可用
  userId  VARCHAR2(200),--上传人id
  userName   VARCHAR2(200),--上传用户名
  extendOne  VARCHAR2(200)--扩展字段
);

-- Add comments to the table 
comment on table T_FILEINFO
  is '附件信息表';
-- Add comments to the columns 
comment on column T_FILEINFO.id
  is '主键id';
comment on column T_FILEINFO.dataType
  is '数据类型';
comment on column T_FILEINFO.fileType
  is '文件类型';
comment on column T_FILEINFO.fileName
  is '文件名称';
comment on column T_FILEINFO.filePath
  is '文件路径';
comment on column T_FILEINFO.fileSize
  is '文件大小';
comment on column T_FILEINFO.remark
  is '备注';
comment on column T_FILEINFO.pigFarmId
  is '猪场id';
comment on column T_FILEINFO.pigFarmName
  is '猪场名称';
comment on column T_FILEINFO.createtime
  is '创建时间';
comment on column T_FILEINFO.isenabled
  is '是否可用';
comment on column T_FILEINFO.userId
  is '上传人id';
comment on column T_FILEINFO.userName
  is '上传用户名';
comment on column T_FILEINFO.extendOne
  is '扩展字段';
