# 3DViewPageTransformer
设置ViewPageTransformer，达到viewpage切换动画，包括3D切换动画，使用简单

话不多说，直接上效果图
----------------------------------- 
<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF9.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF8.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF7.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF6.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF5.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF4.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF3.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF2.gif?raw=true"/></div>

<div align=center><img width="348" height="613" src="https://github.com/LuckLe/3DViewPageTransformer/blob/master/GIF1.gif?raw=true"/></div>



具体使用：
-------------------
```Java
//			"默认", "深入浅出", "立方体", "旋转","左右折叠", "右上角进入" , "右下角进入", "淡入淡出","3D无缩放","3D有缩放"
                case 0:
                    mViewPager.setPageTransformer(true, new DefaultTransformer());
                    break;
                case 1:
                    mViewPager.setPageTransformer(true, new DepthPageTransformer());
                    break;
                case 2:
                    mViewPager.setPageTransformer(true, new CubeTransformer());
                    break;
                case 3:
                    mViewPager.setPageTransformer(true, new RotateTransformer());
                    break;
                case 4:
                    mViewPager.setPageTransformer(true, new AccordionTransformer());
                    break;
                case 5:
                    mViewPager.setPageTransformer(true, new InRightUpTransformer());
                    break;
                case 6:
                    mViewPager.setPageTransformer(true, new InRightDownTransformer());
                    break;
                case 7:
                    mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                    break;
                case 8:
                    mViewPager.setPageTransformer(true, new ThreeDTransformer());
                    break;
                case 9:
                    mViewPager.setPageTransformer(true, new ThreeeDAndScaleTransformer());

```

如有其它好的切换效果，也可告诉我，我更新在此。
