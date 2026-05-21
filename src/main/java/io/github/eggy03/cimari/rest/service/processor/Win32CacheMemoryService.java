package io.github.eggy03.cimari.rest.service.processor;

import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.mapping.processor.Win32CacheMemoryMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class executes the {@link Cimv2#WIN32_CACHE_MEMORY} PowerShell command
 * and maps the resulting output into {@link Win32CacheMemory} objects.
 * </p>
 *
 * @since 0.0.1
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32CacheMemoryService implements CommonServiceInterface<Win32CacheMemory> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32CacheMemoryMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32CacheMemory} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32CacheMemory} objects.
     * Returns a {@link Collections#emptyList()} if no cache memory is detected.
     * @since 0.0.1
     */
    @Override
    @CacheResult(cacheName = "Win32CacheMemory")
    public List<Win32CacheMemory> get(long timeout) {
        final TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_CACHE_MEMORY, timeout);
        return mapper.mapToList(terminalResult.result(), Win32CacheMemory.class);
    }
}
