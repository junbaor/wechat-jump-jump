### 说明
~~这可能是目前效率最高的 "跳一跳" 外挂.~~


已经不是效率最高的, AI 版已经出了, 但是算法不够最优,  
下功能体验的话请移步 https://github.com/faceair/youjumpijump

原理：  
利用投屏功能, 实时显示 Android 画面, 覆盖一层 Jframe, 鼠标打点后计算距离, 利用 adb 点击屏幕触发弹跳
 

### 使用步骤
1. Android 和 PC 安装 Apowersoft 录屏王
2. 开启手机投屏, 打开跳一跳
3. 使用 java -jar wechat-jump-jump.jar 运行
4. 输入投屏的宽、高、跳跃系数
5. 将半透明窗体覆盖到录屏王上方
6. 在电脑上点击第一个小方块和第二个小方块
7. 继续点


### 优势

利用投屏的优势, 减少 adb 拉取手机截屏的耗时

### 截图

![](https://raw.githubusercontent.com/junbaor/wechat-jump-jump/master/screen/1.png)

### 参考
https://github.com/wangshub/wechat_jump_game  
https://github.com/Chaaang/wechat_jumpandjump
