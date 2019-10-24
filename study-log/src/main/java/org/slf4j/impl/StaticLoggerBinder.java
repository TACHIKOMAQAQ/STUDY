package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * @author ：mmzs
 * @date ：Created in 2019/10/23 14:59
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {
    static StaticLoggerBinder staticLoggerBinder = new StaticLoggerBinder();
    public static StaticLoggerBinder getSingleton(){
        return staticLoggerBinder;
    }
    @Override
    public ILoggerFactory getLoggerFactory() {
        return new ILoggerFactory() {
            @Override
            public Logger getLogger(String s) {
                return new Logger() {
                    @Override
                    public String getName() {
                        return null;
                    }

                    @Override
                    public boolean isTraceEnabled() {
                        return false;
                    }

                    @Override
                    public void trace(String s) {

                    }

                    @Override
                    public void trace(String s, Object o) {

                    }

                    @Override
                    public void trace(String s, Object o, Object o1) {

                    }

                    @Override
                    public void trace(String s, Object... objects) {

                    }

                    @Override
                    public void trace(String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isTraceEnabled(Marker marker) {
                        return false;
                    }

                    @Override
                    public void trace(Marker marker, String s) {

                    }

                    @Override
                    public void trace(Marker marker, String s, Object o) {

                    }

                    @Override
                    public void trace(Marker marker, String s, Object o, Object o1) {

                    }

                    @Override
                    public void trace(Marker marker, String s, Object... objects) {

                    }

                    @Override
                    public void trace(Marker marker, String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isDebugEnabled() {
                        return false;
                    }

                    @Override
                    public void debug(String s) {

                    }

                    @Override
                    public void debug(String s, Object o) {

                    }

                    @Override
                    public void debug(String s, Object o, Object o1) {

                    }

                    @Override
                    public void debug(String s, Object... objects) {

                    }

                    @Override
                    public void debug(String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isDebugEnabled(Marker marker) {
                        return false;
                    }

                    @Override
                    public void debug(Marker marker, String s) {

                    }

                    @Override
                    public void debug(Marker marker, String s, Object o) {

                    }

                    @Override
                    public void debug(Marker marker, String s, Object o, Object o1) {

                    }

                    @Override
                    public void debug(Marker marker, String s, Object... objects) {

                    }

                    @Override
                    public void debug(Marker marker, String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isInfoEnabled() {
                        return false;
                    }

                    @Override
                    public void info(String s) {
                        System.err.println("实现："+s);
                    }

                    @Override
                    public void info(String s, Object o) {

                    }

                    @Override
                    public void info(String s, Object o, Object o1) {

                    }

                    @Override
                    public void info(String s, Object... objects) {

                    }

                    @Override
                    public void info(String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isInfoEnabled(Marker marker) {
                        return false;
                    }

                    @Override
                    public void info(Marker marker, String s) {

                    }

                    @Override
                    public void info(Marker marker, String s, Object o) {

                    }

                    @Override
                    public void info(Marker marker, String s, Object o, Object o1) {

                    }

                    @Override
                    public void info(Marker marker, String s, Object... objects) {

                    }

                    @Override
                    public void info(Marker marker, String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isWarnEnabled() {
                        return false;
                    }

                    @Override
                    public void warn(String s) {

                    }

                    @Override
                    public void warn(String s, Object o) {

                    }

                    @Override
                    public void warn(String s, Object... objects) {

                    }

                    @Override
                    public void warn(String s, Object o, Object o1) {

                    }

                    @Override
                    public void warn(String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isWarnEnabled(Marker marker) {
                        return false;
                    }

                    @Override
                    public void warn(Marker marker, String s) {

                    }

                    @Override
                    public void warn(Marker marker, String s, Object o) {

                    }

                    @Override
                    public void warn(Marker marker, String s, Object o, Object o1) {

                    }

                    @Override
                    public void warn(Marker marker, String s, Object... objects) {

                    }

                    @Override
                    public void warn(Marker marker, String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isErrorEnabled() {
                        return false;
                    }

                    @Override
                    public void error(String s) {

                    }

                    @Override
                    public void error(String s, Object o) {

                    }

                    @Override
                    public void error(String s, Object o, Object o1) {

                    }

                    @Override
                    public void error(String s, Object... objects) {

                    }

                    @Override
                    public void error(String s, Throwable throwable) {

                    }

                    @Override
                    public boolean isErrorEnabled(Marker marker) {
                        return false;
                    }

                    @Override
                    public void error(Marker marker, String s) {

                    }

                    @Override
                    public void error(Marker marker, String s, Object o) {

                    }

                    @Override
                    public void error(Marker marker, String s, Object o, Object o1) {

                    }

                    @Override
                    public void error(Marker marker, String s, Object... objects) {

                    }

                    @Override
                    public void error(Marker marker, String s, Throwable throwable) {

                    }
                };
            }
        };
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return this.getClass().getName();
    }
}
