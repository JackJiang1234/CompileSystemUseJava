package com.compile.lexical;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author  jianyong.jiang
 * @date 2019/03/12
 * */
public class SourceFileScannerTest extends ScannerTestBase {

    @Test
    public void testNullOrEmptyFileName(){
        assertThrows(FileNotFoundException.class, () -> new SourceFileScanner(""));
    }

    @Test
    public void testHasContent() {
        String fileName = "lexical/SouceFileScanTestFile.txt";
        Supplier<InputStream> factory = () -> this.getClass().getClassLoader().getResourceAsStream(fileName);
        String content = new BufferedReader(new InputStreamReader(factory.get()))
                .lines().collect(Collectors.joining(System.lineSeparator()));

        this.testContent(content, c -> new SourceFileScanner(factory.get()));
    }
}
