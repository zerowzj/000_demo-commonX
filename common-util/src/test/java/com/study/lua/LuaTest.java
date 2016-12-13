package com.study.lua;

import org.junit.Test;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class LuaTest {

    @Test
    public void test() {
        String script = "D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\lua\\hello.lua";
        // create an environment to run in
        //初始化lua运行时环境
        Globals globals = JsePlatform.standardGlobals();
        // Use the convenience function on Globals to load a chunk.
        //通过Globals加载lua脚本
        LuaValue chunk = globals.loadfile(script);
        // Use any of the "call()" or "invoke()" functions directly on the chunk.
        //运行lua脚本
        chunk.call(LuaValue.valueOf(script));
    }
}
